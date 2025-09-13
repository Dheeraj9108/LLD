package LoggingFrameworkLLD.entities;

import java.time.LocalDateTime;

import LoggingFrameworkLLD.enums.LogLevel;

public class LogMessage {
    String message;
    LocalDateTime timeStamp;
    LogLevel messageLevel;
    String loggerName;

    public LogMessage(String message, String loggerName, LogLevel messageLevel) {
        this.message = message;
        this.loggerName = loggerName;
        this.messageLevel = messageLevel;
        timeStamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public LogLevel getMessageLevel() {
        return messageLevel;
    }

    public String getLoggerName() {
        return loggerName;
    }
    
}
