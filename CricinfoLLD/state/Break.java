package CricinfoLLD.state;

import CricinfoLLD.entities.Ball;
import CricinfoLLD.entities.Match;

public class Break implements MatchState {

    @Override
    public void processBall(Match match, Ball ball) {
    }

    @Override
    public void startNextInnings(Match match) {
        System.out.println("Starting next Inning");
        match.createNextInning();
    }

}
