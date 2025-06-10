package com.archives.crudtask.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
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

    @Override
    public List<Task> getAllTask() {
        jdbcTemplate.query(query, (resultSet) -> {
            Task task = new Task();
            task.setId(resultSet.getString("id"));
            task.setContent(resultSet.getString("content"));
            task.setIsComplete(resultSet.getBoolean("iscomplete"));
            task.setIsProgress(resultSet.getBoolean("isprogress"));
            return task;
        });
        return null;
    }

    @Override
    public List<Task> getTaskByCompleteOrIncomplete(boolean isComplete) {
        if (isComplete) {
            String queryConcat = query.concat(" WHERE iscomplete = true");
            jdbcTemplate.query(queryConcat, (resultSet) -> {
                Task task = new Task();
                task.setId(resultSet.getString("id"));
                task.setContent(resultSet.getString("content"));
                task.setIsComplete(resultSet.getBoolean("iscomplete"));
                task.setIsProgress(resultSet.getBoolean("isprogress"));
                return task;
            });
        } else if (!isComplete) {
            String queryConcat = query.concat(" WHERE iscomplete = false");
            jdbcTemplate.query(queryConcat, (resultSet) -> {
                Task task = new Task();
                task.setId(resultSet.getString("id"));
                task.setContent(resultSet.getString("content"));
                task.setIsComplete(resultSet.getBoolean("iscomplete"));
                task.setIsProgress(resultSet.getBoolean("isprogress"));
                return task;
            });
        }
        return null;
    }

    @Override
    public List<Task> getTaskByProgress() {
        String queryConcat = query.concat("WHERE isprogress = true");
        jdbcTemplate.query(queryConcat, (resultSet) -> {
            Task task = new Task();
            task.setId(resultSet.getString("id"));
            task.setContent(resultSet.getString("content"));
            task.setIsComplete(resultSet.getBoolean("iscomplete"));
            task.setIsProgress(resultSet.getBoolean("isprogress"));
            return task;
        });
        return null;
    }

    @Override
    public void aggTask(Task task) {
        String query = "INSERT INTO tasktable (id, content, iscomplete, isprogress) VALUES(?,?,?,?)";
        UUID id = UUID.randomUUID();
        jdbcTemplate.update(query, id.toString(), task.getContent(), task.getIsComplete(), task.getIsProgress());
    }

    @Override
    public void updateTask(Task task) {
        String query = "UPDATE tasktable SET content = ?, iscomplete = ?, isprogress = ?  WHERE id = ?";
        jdbcTemplate.update(query,task.getContent(), task.getIsComplete(), task.getIsProgress(), task.getId());    
    }

    @Override
    public void deleteTask(UUID id) {
        String query = "DELETE FROM tasktable WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}

