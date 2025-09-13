package LoggingFrameworkLLD.stratergy.formatter;

import java.time.format.DateTimeFormatter;

import LoggingFrameworkLLD.entities.LogMessage;

public class SimpleTextFormatter implements Formatter{
    
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");   

    @Override
    public String format(LogMessage message) {
        return String.format("%s [%s] - %s: %s\n", 
        message.getTimeStamp().format(DATE_TIME_FORMATTER),
        message.getMessageLevel(),
        message.getLoggerName(),
        message.getMessage());
    }
    
}
