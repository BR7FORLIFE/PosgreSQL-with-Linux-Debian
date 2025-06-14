package com.archives.crudtask.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.archives.crudtask.models.Task;
import com.archives.crudtask.repository.interfaces.TaskRepoInterface;

@Repository
public class TaskRepositoryImp implements TaskRepoInterface {

    private final JdbcTemplate jdbcTemplate;
    private final String query = "SELECT id, content, iscomplete, isprogress FROM tasktable";

    public TaskRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Task> taskRowMapper = (resultSet, rowIndex) -> {
        Task task = new Task();
        task.setId(UUID.fromString(resultSet.getString("id")));
        task.setContent(resultSet.getString("content"));
        task.setIsComplete(resultSet.getBoolean("iscomplete"));
        task.setIsProgress(resultSet.getBoolean("isprogress"));
        return task;
    };

    @Override
    public List<Task> getAllTask() {
        return jdbcTemplate.query(query, taskRowMapper);
    }

    @Override
    public Task getTaskById(UUID id){
        String getQuery = query + " WHERE id = ?";
        return jdbcTemplate.queryForObject(getQuery, taskRowMapper, id);
    }

    @Override
    public List<Task> getTaskByCompleteOrIncomplete(boolean isComplete) {
        String newQuery = query + " WHERE iscomplete = ?";
        return jdbcTemplate.query(newQuery, taskRowMapper, isComplete);
    }

    @Override
    public List<Task> getTaskByProgress(boolean isProgress) {
        String newQuery = query + " WHERE isprogress = ?";
        return jdbcTemplate.query(newQuery, taskRowMapper, isProgress);
    }

    @Override
    public void aggTask(Task task) {
        String aggQuery = "INSERT INTO tasktable (id, content, iscomplete, isprogress) VALUES(?,?,?,?)";
        jdbcTemplate.update(aggQuery, task.getId(), task.getContent(), task.getIsComplete(), task.getIsProgress());
    }

    @Override
    public void updateTask(Task task) {
        if (task == null || task.getId() == null) {
            throw new IllegalArgumentException("Tarea o ID no puede ser null");
        }

        final String updateQuery = "UPDATE tasktable SET content = ? , iscomplete = ? , isprogress = ? WHERE id = ?";
        jdbcTemplate.update(updateQuery, task.getContent(), task.getIsComplete(), task.getIsProgress(),
                task.getId());
    }

    @Override
    public void deleteTask(UUID id) {
        String deleteQuery = "DELETE FROM tasktable WHERE id = ?";
        jdbcTemplate.update(deleteQuery, id);
    }
}
