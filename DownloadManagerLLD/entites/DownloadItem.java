package DownloadManagerLLD.entites;

import java.util.UUID;

import DownloadManagerLLD.enums.DownloadStatus;
import DownloadManagerLLD.state.DownloadState;
import DownloadManagerLLD.state.Queued;

public class DownloadItem {
    private String id;
    private String url;
    private String destination;
    private DownloadState state;
    private DownloadStatus status;
    private int downloadPercentage;
    volatile boolean paused = false;
    private Object lock = new Object();

    public DownloadItem(String url, String destination) {
        this.id = UUID.randomUUID().toString();
        this.url = url;
        this.destination = destination;
        state = new Queued();
        status = DownloadStatus.QUEUED;
        this.downloadPercentage = 0;
    }

    public void setState(DownloadState state) {
        this.state = state;
    }
    
    public void setStatus(DownloadStatus status) {
        this.status = status;
    }

    public void download() {
        state.download(this);
    }

    public void pause() {
        state.pause(this);
        paused = true;
    }

    public void resume() {
        synchronized (lock) {
            lock.notifyAll();
            paused = false;
        }
    }

    public void awaiIfPaused() {
        synchronized (lock) {
            while (paused) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public void complete() {
        state.complete(this);
        System.out.println("Download completed");
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDestination() {
        return destination;
    }

    public DownloadState getState() {
        return state;
    }

    public DownloadStatus getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDownloadPercentage() {
        return downloadPercentage;
    }

    public void setDownloadPercentage(int downloadPercentage) {
        this.downloadPercentage = downloadPercentage;
    }

    public String getDownloadSatus() {
        return String.format("Download Status : %s and Percentage : %s", status, this.downloadPercentage);
    }

}
