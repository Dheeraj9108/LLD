package LoggingFrameworkLLD.stratergy.appender;

import LoggingFrameworkLLD.entities.LogMessage;
import LoggingFrameworkLLD.stratergy.formatter.Formatter;
import LoggingFrameworkLLD.stratergy.formatter.SimpleTextFormatter;

public class ConsoleAppender implements LogAppender{

    Formatter formatter;

    public ConsoleAppender(){
        this.formatter = new SimpleTextFormatter();
    }

    @Override
    public void append(LogMessage message) {
        System.out.println(formatter.format(message));
    }

    @Override
    public void close() {
    }
    
}
