package DownloadManagerLLD.state;

import DownloadManagerLLD.entites.DownloadItem;

public class Completed implements DownloadState{

    @Override
    public void download(DownloadItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'download'");
    }

    @Override
    public void complete(DownloadItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'complete'");
    }

    @Override
    public void pause(DownloadItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pause'");
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