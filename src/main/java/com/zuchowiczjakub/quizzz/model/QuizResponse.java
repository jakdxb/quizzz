package com.zuchowiczjakub.quizzz.model;

public class QuizResponse {
    private boolean success;

    private String feedback;

    public QuizResponse(boolean succes, String feedback) {
        this.success = succes;
        this.feedback = feedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
