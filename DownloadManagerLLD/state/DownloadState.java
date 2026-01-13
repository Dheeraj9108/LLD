package DownloadManagerLLD.state;

import DownloadManagerLLD.entites.DownloadItem;

public interface DownloadState {
    void download(DownloadItem item);
    void complete(DownloadItem item);
    void pause(DownloadItem item);
    void resume(DownloadItem item);
    void cancel(DownloadItem item);
}
