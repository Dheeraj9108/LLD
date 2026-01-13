package DownloadManagerLLD.state;

import DownloadManagerLLD.entites.DownloadItem;
import DownloadManagerLLD.enums.DownloadStatus;

public class Downloading implements DownloadState{

    @Override
    public void download(DownloadItem item) {
    }

    @Override
    public void complete(DownloadItem item) {
        item.setState(new Completed());
        item.setStatus(DownloadStatus.COMPLETED);
    }

    @Override
    public void pause(DownloadItem item) {
        item.setState(new Paused());
        item.setStatus(DownloadStatus.PAUSED);
    }

    @Override
    public void resume(DownloadItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resume'");
    }

    @Override
    public void cancel(DownloadItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancel'");
    }
    
}
