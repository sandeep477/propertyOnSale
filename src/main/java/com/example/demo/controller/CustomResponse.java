package com.example.demo.controller;

public class CustomResponse {
    private String message;
    private boolean success;

    // Constructor
    public CustomResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public static class Builder {
        private String message;
        private boolean success;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public CustomResponse build() {
            return new CustomResponse(message, success);
        }
    }	
}

