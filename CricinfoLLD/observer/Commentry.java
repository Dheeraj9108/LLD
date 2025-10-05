package CricinfoLLD.observer;

import CricinfoLLD.entities.Ball;
import CricinfoLLD.entities.Match;
import CricinfoLLD.enums.MatchStatus;

public class Commentry implements Observer{

    @Override
    public void update(Match match, Ball ball) {
        if (match.getStatus() == MatchStatus.FINSHED) {
            System.out.println("Match Finshed");
        } else if (match.getStatus() == MatchStatus.BREAK) {
            System.out.println("Innings Ended");
        } else {
            System.out.println(ball.getCommentary());
        }
    }
    
}
