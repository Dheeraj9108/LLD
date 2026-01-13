package DownloadManagerLLD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DownloadManagerLLD.entites.DownloadTask;

public class DownloadManager {
    
    private static DownloadManager INSTANCE; 

    private ExecutorService service;

    private DownloadManager(int workers) {
        service = Executors.newFixedThreadPool(workers);
    }

    public static DownloadManager getInstance(int workers){
        if(INSTANCE == null){
            synchronized(DownloadManager.class){
                if(INSTANCE == null){
                    INSTANCE = new DownloadManager(workers);
                }
            }
        }
        return INSTANCE;
    } 

    public void submit(DownloadTask task){
        service.submit(task);
    }

    public void shutdown(){
        service.shutdown();
    }
}
