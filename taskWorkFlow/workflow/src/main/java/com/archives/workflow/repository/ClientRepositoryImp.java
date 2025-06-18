package com.archives.workflow.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.archives.workflow.models.Client;
import com.archives.workflow.repository.interfaces.ClientRepositoryInterface;

@Repository
public class ClientRepositoryImp implements ClientRepositoryInterface {

    private JdbcTemplate jdbcTemplate;

    private String readQuery = "SELECT id, name, lastname, email, username, password, rol FROM clients";

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

    public ClientRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> getAllClient() {
        return jdbcTemplate.query(readQuery, rowMapperTemplate);
    }

    @Override
    public Client getClientbyId(UUID id) {
        return null;
    }

    @Override
    public Client getForRol(Client client) {
        return null;
    }

    @Override
    public void saveClient(Client client) {

    }

    @Override
    public Client updateClient(UUID id) {
        return null;
    }

    @Override
    public void deleteClient(UUID id) {

    }
}
