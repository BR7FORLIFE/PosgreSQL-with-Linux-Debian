package com.archives.crudtask.models;

public class Task {
    private String id;
    private String content;
    private boolean isComplete;
    private boolean isProgress;

    public Task(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
