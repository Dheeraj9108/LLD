package DownloadManagerLLD;

import DownloadManagerLLD.entites.DownloadItem;

public class DownloadManagerLLDMain {
    public static void main(String[] args) throws InterruptedException {
        DownloadService service = DownloadService.getInstance();

        DownloadItem item1 = service.download("http://eer.com", "f1");
        // DownloadItem item2 = service.download("http://eera.com", "f2");
        // DownloadItem item3 = service.download("http://eera.com", "f3");
        // DownloadItem item4 = service.download("http://eera.com", "f4");

        Thread.sleep(2000);
        service.pause(item1.getId());
        
        Thread.sleep(2000);
        service.resume(item1.getId());

        service.shutdown();
    }
}
