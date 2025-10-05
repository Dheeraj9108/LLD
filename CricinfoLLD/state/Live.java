package CricinfoLLD.state;

import CricinfoLLD.entities.Ball;
import CricinfoLLD.entities.Inning;
import CricinfoLLD.entities.Match;
import CricinfoLLD.entities.Team;
import CricinfoLLD.enums.MatchStatus;

public class Live implements MatchState {

    @Override
    public void processBall(Match match, Ball ball) {
        Inning currentInning = match.getCurrentInnings();
        currentInning.addBall(ball);
        match.notifyObservers(ball);

        checkForMatchEnd(match);
    }

    private void checkForMatchEnd(Match match) {
        Inning currInning = match.getCurrentInnings();
        int inning = match.getInnings().size();

        if (inning >= match.getStratergy().getInnings()) {
            int score = currInning.getScore();
            if (score > match.getInnings().get(0).getScore()) {
                int winWickets = currInning.getBattingTeam().getPlayers().size() - currInning.getWickets();
                declareWinner(currInning.getBattingTeam(), match,
                        String.format("Team %s won by %s wickets", currInning.getBattingTeam().getName(), winWickets));
                return;
            }
        }

        if (isInningOver(match)) {
            if (inning >= match.getStratergy().getInnings()) {
                int team1Score = match.getInnings().get(0).getScore();
                int team2Score = match.getCurrentInnings().getScore();

                if (team1Score > team2Score) {
                    int winRuns = match.getInnings().get(0).getScore() - match.getCurrentInnings().getScore();
                    declareWinner(match.getCurrentInnings().getBowlingTeam(), match, String.format(
                            "Team %s won by %s runs", match.getCurrentInnings().getBowlingTeam().getName(), winRuns));
                } else if (team2Score > team1Score) {
                    int winWickets = currInning.getBattingTeam().getPlayers().size() - currInning.getWickets();
                    declareWinner(currInning.getBattingTeam(), match,
                            String.format("Team %s won by %s wickets", currInning.getBattingTeam().getName(),
                                    winWickets));
                } else {
                    System.out.println("Match Finshed With Tie");
                    match.setState(new Finsh());
                    match.setStatus(MatchStatus.FINSHED);
                    match.notifyObservers(null);
                }
            } else {
                System.out.println("End of Innings");
                match.setState(new Break());
                match.setStatus(MatchStatus.BREAK);
                match.notifyObservers(null);
            }
        }

    }

    private void declareWinner(Team winner, Match match, String message) {
        match.setWinner(winner);
        match.setState(new Finsh());
        match.setStatus(MatchStatus.FINSHED);
        System.out.println(message);
        match.notifyObservers(null);
    }

    private boolean isInningOver(Match match) {
        boolean allout = match.getCurrentInnings()
                .getWickets() >= match.getCurrentInnings().getBattingTeam().getPlayers().size() - 1;
        boolean isOverFinshed = match.getCurrentInnings().getOvers() >= match.getStratergy().getOvers();
        return allout || isOverFinshed;
    }

}
