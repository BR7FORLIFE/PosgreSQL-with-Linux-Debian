package com.archives.workflow.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.archives.workflow.models.Client;
import com.archives.workflow.models.Projects;
import com.archives.workflow.repository.interfaces.ProjectRepositoryInterface;

@Repository
public class ProjectRepositoryImp implements ProjectRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;
    private final String readQuery = "SELECT id, name, description, date, client_id FROM projects";
    private final String createQuery = "INSERT INTO projects(id, name, description, date, client_id) VALUES (?,?,?,?,?)";

    private final RowMapper<Projects> rowMapperTemplate = (resultSet, row) -> {
        Projects projects = new Projects();
        Client client = new Client();
        
        projects.setId(resultSet.getInt("id"));
        projects.setName(resultSet.getString("name"));
        projects.setDescription(resultSet.getString("description"));
        projects.setDate(resultSet.getDate("date"));
    
        client.setId(UUID.fromString(resultSet.getString("client_id")));
        projects.setClient(client);

        return projects;
    };

    public ProjectRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createProject(Projects project) {
        jdbcTemplate.update(createQuery);
    }

    @Override
    public List<Projects> getAllProjectForUser() {
        return jdbcTemplate.query(readQuery, rowMapperTemplate);
    }

    @Override
    public Projects getDetailsProjectForUser(Projects projects) {
        return null;
    }

    @Override
    public Projects editProject(int id) {
        return null;
    }

    @Override
    public void deleteProject(int id) {

    }
}
