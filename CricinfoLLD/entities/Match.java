package CricinfoLLD.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import CricinfoLLD.enums.MatchStatus;
import CricinfoLLD.observer.Observer;
import CricinfoLLD.state.Live;
import CricinfoLLD.state.MatchState;
import CricinfoLLD.state.Scheduled;
import CricinfoLLD.stratergy.MatchFormatStratergy;

public class Match {
    private String id;
    private Team team1;
    private Team team2;   
    private Team winner;
    private MatchState state;
    private MatchStatus status;
    private List<Inning> innings;
    private List<Observer> observers;
    private MatchFormatStratergy stratergy;
    
    public Match(Team team1, Team team2, MatchFormatStratergy stratergy) {
        this.id = UUID.randomUUID().toString();
        this.team1 = team1;
        this.team2 = team2;
        this.winner = null;
        this.state = new Scheduled();
        this.status = MatchStatus.SCHEDULED;
        this.stratergy = stratergy;
        this.innings = new ArrayList<>();
        this.innings.add(new Inning(team1, team2));  
        this.observers = new ArrayList<>();
    }

    public void start(){
        this.state = new Live();
        this.status = MatchStatus.LIVE;
    }

    public void processBall(Ball ball){
        state.processBall(this,ball);
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(Ball ball){
        for(Observer observer : observers){
            observer.update(this,ball);
        }
    } 

    public void createNextInning(){
        if(innings.size() >= stratergy.getInnings()) {
            System.out.println("All innings are done");
            return;
        }

        innings.add(new Inning(team2, team1));
    }

    public void startNextInning(){
        state.startNextInnings(this);
    }

    public void setWinner(Team winner){
        this.winner = winner;
    }

    public void setStatus(MatchStatus status){
        this.status = status;
    }

    public void setState(MatchState state){
        this.state = state;
    }

    public Inning getCurrentInnings(){
        return innings.get(innings.size()-1);
    }

    public String getId() {
        return id;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Team getWinner() {
        return winner;
    }

    public MatchState getState() {
        return state;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public List<Inning> getInnings() {
        return innings;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public MatchFormatStratergy getStratergy() {
        return stratergy;
    }

}
