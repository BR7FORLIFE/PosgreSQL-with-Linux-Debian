package com.archives.workflow.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.archives.workflow.models.enums.STATUS;

public class Projects {
    private int id;
    private String name;
    private String description;
    private LocalDateTime  date;
    private STATUS status;
    private UUID client_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public STATUS getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setClient_id(UUID client_id) {
        this.client_id = client_id;
    }

    public UUID getClient_id() {
        return client_id;
    }
}
