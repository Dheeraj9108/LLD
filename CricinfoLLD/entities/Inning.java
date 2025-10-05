package CricinfoLLD.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CricinfoLLD.enums.ExtraType;

public class Inning {
    private List<Ball> balls;
    private Team battingTeam;
    private Team bowlingTeam;
    private Map<Player, PlayerStat> playerStats;
    private int score;
    private int wickets;

    public Inning(Team battingTeam, Team bowlingTeam) {
        this.balls = new ArrayList<>();
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.playerStats = new HashMap<>();
        this.score = 0;
        this.wickets = 0;

        for (Player player : battingTeam.getPlayers()) {
            playerStats.put(player, new PlayerStat());
        }

        for (Player player : bowlingTeam.getPlayers()) {
            playerStats.put(player, new PlayerStat());
        }
    }

    public void addBall(Ball ball) {
        balls.add(ball);
        score += ball.getRunScored();
        if (ball.getType() == ExtraType.WIDE || ball.getType() == ExtraType.NO_BALL)
            score++;
        else {
            playerStats.get(ball.getPlayedBy()).updateRun(score);
            playerStats.get(ball.getPlayedBy()).incrementBallPlayed();
            ball.getPlayedBy().getStat().updateRun(score);
            ball.getPlayedBy().getStat().incrementBallPlayed();
        }

        if (ball.isWicket()) {
            playerStats.get(ball.getBowledBy()).incrementWickets();
            ball.getBowledBy().getStat().incrementWickets();
        }
    }

    public double getOvers() {
        long validBalls = balls.stream()
                .filter(ball -> ball.getType() != ExtraType.WIDE && ball.getType() != ExtraType.NO_BALL).count();

        long overs = validBalls / 6;
        long rem = validBalls % 6;

        return overs + (rem / 10.0);

    }

    public List<Ball> getBalls() {
        return balls;
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public Map<Player, PlayerStat> getPlayerStats() {
        return playerStats;
    }

    public int getScore() {
        return score;
    }

    public int getWickets() {
        return wickets;
    }

    public void printPlayerStats() {
        for (Map.Entry<Player, PlayerStat> set : playerStats.entrySet()) {
            System.out.printf("Player %s runs %s wickets %s balls played %s\n", set.getKey().getName(),
                    set.getValue().getRuns(), set.getValue().getWickets(), set.getValue().getBallPlayed());
        }
    }
}
