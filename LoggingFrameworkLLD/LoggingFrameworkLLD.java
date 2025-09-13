package LoggingFrameworkLLD;

import LoggingFrameworkLLD.enums.LogLevel;
import LoggingFrameworkLLD.stratergy.appender.ConsoleAppender;
import LoggingFrameworkLLD.stratergy.appender.FileAppender;

public class LoggingFrameworkLLD {
    public static void main(String[] args) {
        LogManager manager = LogManager.getInstance();
        
        Logger root = manager.getRootLogger();
        root.setLogLevel(LogLevel.DEBUG);

        Logger main = manager.getLogger("com.example.main");
        main.setLogLevel(LogLevel.INFO);
        main.addAppender(new ConsoleAppender());
        main.addAppender(new FileAppender("C:\\Users\\HP\\Desktop\\New folder\\LoggingFramework\\src\\temp\\log"));
        main.info("Info Log");
        main.error("Error Log");
        main.warn("warn log");
         try {
            Thread.sleep(5000);
            manager.shutdown();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }
    }   
}
