package com.archives.crudtask.models;

import java.util.UUID;

public class Task {
    private UUID id;
    private String content;
    private boolean isComplete;
    private boolean isProgress;

    public Task(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Boolean getIsProgress() {
        return isProgress;
    }

    public void setIsProgress(boolean isProgress) {
        this.isProgress = isProgress;
    }
}
