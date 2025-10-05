package CricinfoLLD;

import CricinfoLLD.entities.Ball;
import CricinfoLLD.entities.Match;
import CricinfoLLD.entities.Player;
import CricinfoLLD.entities.Team;
import CricinfoLLD.enums.PlayerType;
import CricinfoLLD.observer.Observer;
import CricinfoLLD.repository.MatchRepository;
import CricinfoLLD.repository.PlayerRepository;
import CricinfoLLD.state.Finsh;
import CricinfoLLD.stratergy.MatchFormatStratergy;

public class CricinfoService {
    private static CricinfoService INSTANCE;
    private PlayerRepository playerRepository;
    private MatchRepository matchRepository;

    private CricinfoService() {
        playerRepository = new PlayerRepository();
        matchRepository = new MatchRepository();
    }

    public static CricinfoService getInstance() {
        if (INSTANCE == null) {
            synchronized (CricinfoService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CricinfoService();
                }
            }
        }
        return INSTANCE;
    }

    public Player addPlayer(String name, PlayerType type) {
        Player player = new Player(name, type);
        playerRepository.save(player);
        return player;
    }

    public Match addMatch(Team team1, Team team2, MatchFormatStratergy stratergy) {
        Match match = new Match(team1, team2, stratergy);
        matchRepository.save(match);
        return match;
    }

    public void startMatch(String matchId) {
        Match match = matchRepository.getMatchById(matchId);
        match.start();
    }

    public void processBallUpdate(String matchId, Ball ball) {
        Match match = matchRepository.getMatchById(matchId);
        match.processBall(ball);
    }

    public void startNextInning(String matchId) {
        Match match = matchRepository.getMatchById(matchId);
        match.startNextInning();
    }

    public void subscribeToMatch(String matchId, Observer observer) {
        Match match = matchRepository.getMatchById(matchId);
        match.addObserver(observer);
    }
    
    public void endMatch(String matchId){
        Match match = matchRepository.getMatchById(matchId);
        match.setState(new Finsh());
    }
}
