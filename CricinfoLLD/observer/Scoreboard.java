package CricinfoLLD.observer;

import CricinfoLLD.entities.Ball;
import CricinfoLLD.entities.Inning;
import CricinfoLLD.entities.Match;
import CricinfoLLD.enums.MatchStatus;

public class Scoreboard implements Observer {

    @Override
    public void update(Match match, Ball ball) {
        if (match.getStatus() == MatchStatus.FINSHED) {
            System.out.println("Player Stats");

            for (Inning inning : match.getInnings()) {
                inning.printPlayerStats();
            }
        } else if (match.getStatus() == MatchStatus.BREAK) {
            System.out.printf("Team %s runs %s wickets %s overs %s \n",
                    match.getCurrentInnings().getBattingTeam().getName(), match.getCurrentInnings().getScore(),
                    match.getCurrentInnings().getWickets(), match.getCurrentInnings().getOvers());
        } else {
            System.out.println("-----------Score Update---------");
            System.out.printf("Team %s runs %s wickets %s over %s \n",
            match.getCurrentInnings().getBattingTeam().getName(), match.getCurrentInnings().getScore(),
            match.getCurrentInnings().getWickets(), match.getCurrentInnings().getOvers());
            System.out.println("-------------------------------");
        }
    }

}
