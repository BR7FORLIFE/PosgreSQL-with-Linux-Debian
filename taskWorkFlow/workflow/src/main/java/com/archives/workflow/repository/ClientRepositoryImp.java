package com.archives.workflow.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.archives.workflow.models.Client;
import com.archives.workflow.repository.interfaces.ClientRepositoryInterface;

@Repository
public class ClientRepositoryImp implements ClientRepositoryInterface {

    private JdbcTemplate jdbcTemplate;

    // querys for the client sql
    private String readQuery = "SELECT id, name, lastname, email, username, password, rol FROM clients";
    private String createQuery = "INSERT INTO clients (id, name, lastname, email, username, password, rol) VALUES (?,?,?,?,?,?,?)";
    private String updateQuery = "UPDATE clients SET name = ?, lastname = ?, email = ?, username = ? , password = ?, rol = ? WHERE id = ?";
    private String deleteQuery = "DELETE FROM clients WHERE id = ?";

    //row mapper for define the rows of databse
    private RowMapper<Client> rowMapperTemplate = (resultSet, row) -> {
        Client client = new Client();
        client.setId(UUID.fromString(resultSet.getString("id")));
        client.setName(resultSet.getString("name"));
        client.setLastname(resultSet.getString("lastname"));
        client.setEmail(resultSet.getString("email"));
        client.setUsername(resultSet.getString("username"));
        client.setPassword(resultSet.getString("password"));
        client.setRol(resultSet.getString("rol"));

        return client;
    };

    private final RowMapper<Client> rowMapperVerifiedUser = (resultSet, row) -> {
        Client client = new Client();
        client.setId(UUID.fromString(resultSet.getString("id")));
        return client;
    };

    //methods
    public ClientRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> getAllClient() {
        return jdbcTemplate.query(readQuery, rowMapperTemplate);
    }

    @Override
    public Client getClientbyId(UUID id) {
        String newQuery = readQuery + " WHERE id = ?";
        return jdbcTemplate.queryForObject(newQuery, rowMapperTemplate, id);
    }

    @Override
    public Client getForRol(Client client) {
        String newQuery = readQuery + " WHERE rol = ?";
        return jdbcTemplate.queryForObject(newQuery, rowMapperTemplate, client.getRol());
    }

    @Override
    public Boolean getExitsForClient(UUID id) {
        try {
            String newQuery = "SELECT id FROM clients WHERE id = ?";
            jdbcTemplate.queryForObject(newQuery, rowMapperVerifiedUser, String.valueOf(id));
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public void saveClient(Client client) {
        jdbcTemplate.update(createQuery, client.getId(), client.getName(), client.getLastname(), client.getEmail(),
                client.getUsername(), client.getPassword(), client.getRol());
    }

    @Override
    public void updateClient(Client client) {
        jdbcTemplate.update(updateQuery, client.getName(), client.getLastname(), client.getEmail(),
                client.getUsername(), client.getPassword(), client.getRol());
    }

    @Override
    public void deleteClient(UUID id) {
        jdbcTemplate.update(deleteQuery, id);
    }
}
