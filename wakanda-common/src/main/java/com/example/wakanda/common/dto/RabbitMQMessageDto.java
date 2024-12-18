package com.example.wakanda.common.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMQMessageDto {
    private String id;
    private String payload;
    private Date timestamp;

    public boolean isEmptyPayload() {
        return payload == null || payload.trim().isEmpty();
    }

    public boolean isOlderThan(long milliseconds) {
        return timestamp != null && (new Date().getTime() - timestamp.getTime()) > milliseconds;
    }

    public void updateTimestamp() {
        this.timestamp = new Date();
    }
}
