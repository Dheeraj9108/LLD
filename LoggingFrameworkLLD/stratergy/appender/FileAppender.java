package LoggingFrameworkLLD.stratergy.appender;

import java.io.FileWriter;
import java.io.IOException;

import LoggingFrameworkLLD.entities.LogMessage;
import LoggingFrameworkLLD.stratergy.formatter.Formatter;
import LoggingFrameworkLLD.stratergy.formatter.SimpleTextFormatter;

public class FileAppender implements LogAppender{
    
    FileWriter writer;
    Formatter formatter;

    public FileAppender(String filePath){
        formatter = new SimpleTextFormatter();
        try {
            writer = new FileWriter(filePath,true);
        } catch (Exception e) {
            System.out.println("Failed to create writer"+e.getMessage());
        }
    }
    
    @Override
    public void append(LogMessage message) {
        try {
            writer.write(formatter.format(message));
            writer.flush();
        } catch (IOException e) {
            System.out.println("Failed to write logs");
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to close writer");
        }
    }
    
}
