package com.archives.workflow.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.archives.workflow.models.Projects;
import com.archives.workflow.models.enums.STATUS;
import com.archives.workflow.repository.interfaces.ProjectRepositoryInterface;

@Repository
public class ProjectRepositoryImp implements ProjectRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;
    private final String readQuery = "SELECT id, name, description, date, status , client_id FROM projects";
    private final String createQuery = "INSERT INTO projects(id, name, description, date, status ,client_id) VALUES (?,?,?,?,?,?)";
    private final String updateQuery = "UPDATE projects SET name = ?, description = ?, status = ? WHERE id = ?";

    private final String deleteQuery = "DELETE FROM projects WHERE id = ?";

    private final RowMapper<Projects> rowMapperTemplate = (resultSet, row) -> {
        Projects projects = new Projects();
        projects.setId(resultSet.getInt("id"));
        projects.setName(resultSet.getString("name"));
        projects.setDescription(resultSet.getString("description"));
        // Convertir el string de la DB a enum
        projects.setStatus(STATUS.valueOf(resultSet.getString("status")));

        // Convertir el timestamp a LocalDateTime (o LocalDate según uses)
        projects.setDate(resultSet.getTimestamp("date").toLocalDateTime());

        // Suponiendo que tienes client_id también en Projects
        projects.setClient_id(UUID.fromString(resultSet.getString("client_id")));

        return projects;
    };

    public ProjectRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createProject(Projects project) {
        jdbcTemplate.update(createQuery,project.getId(), project.getName(), project.getDescription(), project.getDate(),project.getStatus(),project.getClient_id());
    }

    @Override
    public List<Projects> getAllProjectForUser(UUID id) {
        return jdbcTemplate.query(readQuery, rowMapperTemplate, id);
    }

    @Override
    public Projects getProjectById(int id) {
        String newQuery = readQuery + " WHERE id = ?";
        return jdbcTemplate.queryForObject(newQuery, rowMapperTemplate, id);
    }

    // update
    @Override
    public void editProject(Projects project) {
        jdbcTemplate.update(updateQuery, project.getName(), project.getDescription(), project.getId());
    }

    @Override
    public void deleteProject(int id) {
        jdbcTemplate.update(deleteQuery, id);
    }
}
