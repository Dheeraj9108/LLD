package CricinfoLLD;

import java.util.List;

import CricinfoLLD.entities.Ball;
import CricinfoLLD.entities.Match;
import CricinfoLLD.entities.Player;
import CricinfoLLD.entities.Team;
import CricinfoLLD.entities.Wicket;
import CricinfoLLD.enums.PlayerType;
import CricinfoLLD.enums.WicketType;
import CricinfoLLD.observer.Commentry;
import CricinfoLLD.observer.Scoreboard;
import CricinfoLLD.observer.UserNotifier;
import CricinfoLLD.stratergy.T20;

public class CricinfoLLDain {
    public static void main(String[] args) {
        CricinfoService service = CricinfoService.getInstance();

        // 1. Setup Players and Teams
        Player p1 = service.addPlayer("Virat", PlayerType.BATTER);
        Player p2 = service.addPlayer("Rohit", PlayerType.BATTER);
        Player p3 = service.addPlayer("Bumrah", PlayerType.BOWLER);
        Player p4 = service.addPlayer("Jadeja", PlayerType.ALLROUNDER);

        Player p5 = service.addPlayer("Warner", PlayerType.BATTER);
        Player p6 = service.addPlayer("Smith", PlayerType.BATTER);
        Player p7 = service.addPlayer("Starc", PlayerType.BOWLER);
        Player p8 = service.addPlayer("Maxwell", PlayerType.ALLROUNDER);

        Team india = new Team("India", List.of(p1, p2, p3, p4));
        Team australia = new Team("Australia", List.of(p5, p6, p7, p8));

        // 2. Create a T20 Match using the service
        Match t20Match = service.addMatch(india, australia, new T20());
        String matchId = t20Match.getId();

        // 3. Create and subscribe observers
        Scoreboard scorecard = new Scoreboard();
        Commentry commentary = new Commentry();
        UserNotifier notifier = new UserNotifier();

        service.subscribeToMatch(matchId, scorecard);
        service.subscribeToMatch(matchId, commentary);
        service.subscribeToMatch(matchId, notifier);

        // 4. Start the match
        service.startMatch(matchId);

        System.out.println("\n--- SIMULATING FIRST INNINGS ---");
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p7).facedBy(p1).withRuns(2).build());
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p7).facedBy(p1).withRuns(1).build());
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p7).facedBy(p2).withRuns(6).build());

        Wicket p2Wicket = new Wicket.Builder(WicketType.BOWLED, p2).build();
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p7).facedBy(p2).withRuns(0).withWicket(p2Wicket).build());

        Wicket p3Wicket = new Wicket.Builder(WicketType.LBW, p3).build();
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p7).facedBy(p3).withRuns(0).withWicket(p3Wicket).build());

        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p7).facedBy(p4).withRuns(4).build());

        Wicket p4Wicket = new Wicket.Builder(WicketType.CAUGHT, p4).caughtBy(p6).build();
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p7).facedBy(p4).withRuns(0).withWicket(p4Wicket).build());

        // The system is now in an IN_BREAK state
        System.out.println("\n\n--- INNINGS BREAK ---");
        System.out.println("Players are off the field. Preparing for the second innings.");

        // 2. Start the second innings
        service.startNextInning(matchId);

        System.out.println("\n--- SIMULATING SECOND INNINGS ---");
        // Simulate a few balls of the second innings to show it works
        // Now Australia is batting (p5, p6) and India is bowling (p3)
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p3).facedBy(p5).withRuns(4).build());

        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p3).facedBy(p5).withRuns(1).build());

        Wicket p5Wicket = new Wicket.Builder(WicketType.BOWLED, p5).build();
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p3).facedBy(p5).withRuns(0).withWicket(p5Wicket).build());

        Wicket p7Wicket = new Wicket.Builder(WicketType.LBW, p7).build();
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p3).facedBy(p7).withRuns(0).withWicket(p7Wicket).build());

        Wicket p8Wicket = new Wicket.Builder(WicketType.STUMPED, p8).build();
        service.processBallUpdate(matchId, new Ball.BallBuilder()
                .bowledBy(p3).facedBy(p8).withRuns(0).withWicket(p8Wicket).build());

        service.endMatch(matchId);
    }    
}
