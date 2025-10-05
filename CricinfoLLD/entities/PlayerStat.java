package CricinfoLLD.entities;

public class PlayerStat {
    private int runs;
    private int ballPlayed;
    private int wickets;

    public void updateRun(int run) {
        this.runs += run;
    }

    public int getRuns() {
        return runs;
    }

    public void incrementBallPlayed() {
        this.ballPlayed++;
    }

    public int getBallPlayed() {
        return ballPlayed;
    }

    public void incrementWickets(){
        this.wickets++;
    }

    public int getWickets() {
        return wickets;
    }
}
