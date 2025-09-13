package LoggingFrameworkLLD.stratergy.formatter;

import LoggingFrameworkLLD.entities.LogMessage;

public interface Formatter {
    public String format(LogMessage message);
}
