package LoggingFrameworkLLD;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogManager {

    private static LogManager INSTANCE;
    private Logger rootLogger;
    private final Map<String, Logger> loggers = new ConcurrentHashMap<>();
    private AsyncLogProcessor processor;

    private LogManager() {
        rootLogger = new Logger("root", null);
        loggers.put(rootLogger.getName(), rootLogger);
        processor = new AsyncLogProcessor();
    }

    public static LogManager getInstance() {
        if (INSTANCE == null) {
            synchronized (LogManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LogManager();
                }
            }
        }
        return INSTANCE;
    }

    public Logger getLogger(String name) {
        Logger logger = createLogger(name);
        Logger l = loggers.putIfAbsent(name, logger) ;
        return l == null ? logger : l;
    }

    private Logger createLogger(String name) {
        if (name.equals("root"))
            return rootLogger;

        int idx = name.lastIndexOf('.');
        String parentName = idx == -1 ? "root" : name.substring(0, idx);
        Logger parent = getLogger(parentName);
        return new Logger(name ,parent);
    }

    public Logger getRootLogger(){
        return rootLogger;
    }

    public AsyncLogProcessor getProcessor(){
        return processor;
    }

    public void shutdown(){
        processor.shutdown();

        loggers.values().stream()
        .flatMap(logger->logger.appenders.stream())
        .forEach(appender->appender.close());
    }
}
