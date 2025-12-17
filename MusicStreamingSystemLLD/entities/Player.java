package MusicStreamingSystemLLD.entities;

import java.util.List;

import MusicStreamingSystemLLD.enums.PlayerStatus;
import MusicStreamingSystemLLD.state.PlayerState;
import MusicStreamingSystemLLD.state.Stopped;

public class Player {

    private int currIdx;
    private Song curSong;
    private User curUser;
    private List<Song> songs;
    private PlayerState state;
    private PlayerStatus status;

    public Player(){
        this.state = new Stopped();
        this.status = PlayerStatus.STOPPED;
    }
    
    public void load(Playable playable, User user){
        this.songs = playable.getTracks();
        this.curUser = user;
        this.currIdx = 0;
        this.state = new Stopped();
        this.status = PlayerStatus.STOPPED;
        System.out.println("Track loaded");
    }
    
    public boolean isQueueEmpty(){
        return songs.isEmpty();
    }

    public void play(){
        state.play(this);
    }

    public void pause(){
        state.pause(this);
    }

    public void stop(){
        state.stop(this);
    }

    public void next(){
        if(currIdx < songs.size()-1){
            System.out.println("playing next song");
            currIdx++;
            playSongInQueue();
        } else {
            System.out.println(" All songs are played");
            state.stop(this);
        }
    }

    public void setState(PlayerState state){
        this.state = state;
    }

    public void setStatus(PlayerStatus status){
        this.status = status;
    }

    public void playSongInQueue(){
        if(currIdx >= 0 && currIdx < songs.size()){
            Song song = songs.get(currIdx); 
            curUser.getStratergy().play(song, this);
        }
    }

    public void setCurSong(Song song){
        this.curSong = song;
    }

    public int getCurrIdx() {
        return currIdx;
    }

    public Song getCurSong() {
        return curSong;
    }

    public User getCurUser() {
        return curUser;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public PlayerState getState() {
        return state;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    
}
