package DownloadManagerLLD.entites;

public class DownloadTask implements Runnable{

    private DownloadItem item;

    public DownloadTask(DownloadItem item) {
        this.item = item;
    }

    @Override
    public void run() {
        int cnt = 0 ;
        item.download();
        while(true){
            item.awaiIfPaused();
            cnt++;
            if(cnt == 5) break;
            try {
                Thread.sleep(2000);
                item.setDownloadPercentage(cnt*10);
                System.out.printf("Id: %s Progress: %s \n",item.getId(),item.getDownloadPercentage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        item.complete();
    }
    
}
