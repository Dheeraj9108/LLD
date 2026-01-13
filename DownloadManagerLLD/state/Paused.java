package DownloadManagerLLD.state;

import DownloadManagerLLD.entites.DownloadItem;
import DownloadManagerLLD.enums.DownloadStatus;

public class Paused implements DownloadState{

    @Override
    public void download(DownloadItem item) {
    }

    @Override
    public void complete(DownloadItem item) {
    }

    @Override
    public void pause(DownloadItem item) {
    }

    @Override
    public void resume(DownloadItem item) {
        item.setState(new Downloading());
        item.setStatus(DownloadStatus.DOWNLOADING);
    }   

    @Override
    public void cancel(DownloadItem item) {
    }
    
}
