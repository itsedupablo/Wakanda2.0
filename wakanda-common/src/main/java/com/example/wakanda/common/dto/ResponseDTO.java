package com.example.wakanda.common.dto;

public class ResponseDTO {
    private String status;
    private String message;

    //Constructor
    public ResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }
    // Getters y Setters
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}