package com.archives.crudtask;

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
    private final String query = "SELECT content, iscomplete, isprogress FROM tasktable";

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
    public List<Task> getTaskByCompleteOrIncomplete(boolean isComplete) {
        String newQuery = query + " WHERE iscomplete = ?";
        return jdbcTemplate.query(newQuery, taskRowMapper, isComplete);
    }

    @Override
    public List<Task> getTaskByProgress() {
        String newQuery = query + " WHERE isprogress = ?";
        return jdbcTemplate.query(newQuery, taskRowMapper);
    }

    @Override
    public void aggTask(Task task) {
        String query = "INSERT INTO tasktable (id, content, iscomplete, isprogress) VALUES(?,?,?,?)";
        jdbcTemplate.update(query, task.getId(), task.getContent(), task.getIsComplete(), task.getIsProgress());
    }

    @Override
    public void updateTask(Task task) {
        String query = "UPDATE tasktable SET content = ?, iscomplete = ?, isprogress = ?  WHERE id = ?";
        jdbcTemplate.update(query, task.getContent(), task.getIsComplete(), task.getIsProgress(), task.getId());
    }

    @Override
    public void deleteTask(UUID id) {
        String query = "DELETE FROM tasktable WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
