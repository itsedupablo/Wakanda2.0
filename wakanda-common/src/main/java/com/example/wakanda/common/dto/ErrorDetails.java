package com.example.wakanda.common.dto;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public String formatError() {
        return "[" + timestamp + "] " + message + ": " + details;
    }

    public void updateError(String newMessage, String newDetails) {
        this.message = newMessage;
        this.details = newDetails;
        this.timestamp = new Date();
    }
}
