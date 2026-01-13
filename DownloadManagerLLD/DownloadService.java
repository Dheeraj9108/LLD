package DownloadManagerLLD;

import java.util.HashMap;
import java.util.Map;

import DownloadManagerLLD.entites.DownloadItem;
import DownloadManagerLLD.entites.DownloadTask;

public class DownloadService {

    private static DownloadService INSTANCE;
    private Map<String, DownloadItem> items;
    private DownloadManager manager;

    private DownloadService() {
        items = new HashMap<>();
        manager = DownloadManager.getInstance(3);
    }

    public static DownloadService getInstance() {
        if (INSTANCE == null) {
            synchronized (DownloadService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DownloadService();
                }
            }
        }
        return INSTANCE;
    }

    public DownloadItem download(String url, String dest) {
        DownloadItem item = new DownloadItem(url, dest);
        items.put(item.getId(), item);
        manager.submit(new DownloadTask(item));
        return item;
    }

    public void pause(String itemId){
        System.out.printf("Pausing download for Item %s \n",itemId);
        DownloadItem item = items.get(itemId);
        item.pause();
    }
    
    public void resume(String itemId){
        System.out.printf("Resuming download for Item %s \n",itemId);
        DownloadItem item = items.get(itemId);
        item.resume();
    }

    public void shutdown(){
        manager.shutdown();
    }
}
