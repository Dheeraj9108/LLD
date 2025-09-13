package LoggingFrameworkLLD;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import LoggingFrameworkLLD.entities.LogMessage;
import LoggingFrameworkLLD.stratergy.appender.LogAppender;

public class AsyncLogProcessor {

    private final ExecutorService service;

    public AsyncLogProcessor(){
        this.service = Executors.newSingleThreadExecutor(runnable->{
            Thread thread = new Thread(runnable,"Async processor");
            thread.setDaemon(true);
            return thread;
        });
    }

    public void process(List<LogAppender> appenders,LogMessage message){
        if(service.isShutdown()){
            System.err.println("Logger is shutdown cannot process the logs");
            return;
        }
        service.submit(()->{
            for(LogAppender appender : appenders){
                appender.append(message);
            }
        });
    }

    public void shutdown(){
        service.shutdown();
        try {
            if(!service.awaitTermination(2, TimeUnit.MILLISECONDS)){
                System.out.println("Processor didn't shutdown in specified time.");
                service.shutdownNow();
            }
        } catch (Exception e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
