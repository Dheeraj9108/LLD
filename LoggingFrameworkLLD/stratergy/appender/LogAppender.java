package LoggingFrameworkLLD.stratergy.appender;

import LoggingFrameworkLLD.entities.LogMessage;

public interface LogAppender {
    public void append(LogMessage message);
    public void close();
}
