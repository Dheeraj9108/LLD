package LoggingFrameworkLLD;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import LoggingFrameworkLLD.entities.LogMessage;
import LoggingFrameworkLLD.enums.LogLevel;
import LoggingFrameworkLLD.stratergy.appender.LogAppender;

public class Logger {

    String name;
    Logger parent;
    LogLevel level;
    boolean aditivity = true;
    List<LogAppender> appenders = new CopyOnWriteArrayList<>();

    public Logger(String name, Logger parent){
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Logger getParent() {
        return parent;
    }

    public void setAditivity(boolean aditivity){
        this.aditivity = aditivity;
    }

    public void setLogLevel(LogLevel level){
        this.level = level;
    }

    public void addAppender(LogAppender appender){
        appenders.add(appender);
    }

    public LogLevel getEffectiveLogLevel(){
        for(Logger logger = this; logger != null ; logger = logger.parent){ 
            if(logger.level != null) return logger.level;
        }
        return LogLevel.DEBUG;
    }

    public void log(String message, LogLevel level){
        if(level.getIsLevelGreaterThan(getEffectiveLogLevel())){
            LogMessage logMessage = new LogMessage(message,name,level);
            this.callAppenders(logMessage);
        }
    }

    private void callAppenders(LogMessage message){
        if(!appenders.isEmpty()){
          LogManager.getInstance().getProcessor().process(appenders,message);  
        }
        if(aditivity && parent != null){
            parent.callAppenders(message);
        }
    }

    public void debug(String message){
        log(message, LogLevel.DEBUG);
    }

    public void warn(String message){
        log(message, LogLevel.WARN);
    }

    public void info(String message){
        log(message, LogLevel.INFO);
    }

    public void error(String message){
        log(message, LogLevel.ERROR);    
    }

    public void fatal(String message){
        log(message, LogLevel.FATAL);
    }
}
