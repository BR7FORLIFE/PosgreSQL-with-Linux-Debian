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
    private final String updateQuery = "UPDATE projects SET name = ?, description = ? WHERE id = ?";

    private final String deleteQuery = "DELETE FROM projects WHERE id = ?";

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
    public List<Projects> getAllProjectForUser(UUID id) {
        return jdbcTemplate.query(readQuery, rowMapperTemplate);
    }

    @Override
    public Projects getProjectById(int id){
        String newQuery = readQuery + " WHERE id = ?";
        return jdbcTemplate.queryForObject(newQuery, rowMapperTemplate);
    }
    // este es jodido
    @Override
    public Projects getDetailsProjectForUser(Projects projects) {
        return null;
    }

    //update
    @Override
    public void editProject(Projects project) {
       jdbcTemplate.update(updateQuery, project.getName(), project.getDescription(), project.getId());
    }

    @Override
    public void deleteProject(int id) {
        jdbcTemplate.update(deleteQuery);
    }
}
