package com.mad.fitapp;

public class UserProgress {

    private String progressId;
    private String completedSteps;
    private String completedHeartPoints;

    public UserProgress() {
    }

    public UserProgress(String progressId, String completedSteps, String completedHeartPoints) {
        this.progressId = progressId;
        this.completedSteps = completedSteps;
        this.completedHeartPoints = completedHeartPoints;
    }

    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }

    public String getCompletedSteps() {
        return completedSteps;
    }

    public void setCompletedSteps(String completedSteps) {
        this.completedSteps = completedSteps;
    }

    public String getCompletedHeartPoints() {
        return completedHeartPoints;
    }

    public void setCompletedHeartPoints(String completedHeartPoints) {
        this.completedHeartPoints = completedHeartPoints;
    }
}
