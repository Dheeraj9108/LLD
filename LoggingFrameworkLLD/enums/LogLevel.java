package LoggingFrameworkLLD.enums;

public enum LogLevel {
    DEBUG(1),
    WARN(2),
    INFO(3),
    ERROR(4),
    FATAL(5);

    private int val;

    LogLevel(int val){
        this.val = val;
    }

    public boolean getIsLevelGreaterThan(LogLevel level){
        return this.val >= level.val;
    } 
}
