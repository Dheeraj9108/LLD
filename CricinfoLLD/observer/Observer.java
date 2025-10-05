package CricinfoLLD.observer;

import CricinfoLLD.entities.Ball;
import CricinfoLLD.entities.Match;

public interface Observer {
    public void update(Match match,Ball ball);
}
