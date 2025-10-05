package CricinfoLLD.state;

import CricinfoLLD.entities.Ball;
import CricinfoLLD.entities.Match;

public interface MatchState {
    public void processBall(Match match,Ball ball);

    default void startNextInnings(Match match) {}
}
