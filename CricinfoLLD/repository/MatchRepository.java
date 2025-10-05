package CricinfoLLD.repository;

import java.util.HashMap;
import java.util.Map;

import CricinfoLLD.entities.Match;

public class MatchRepository {
    private Map<String,Match> matches;

    public MatchRepository() {
        this.matches = new HashMap<>();
    }

    public void save(Match match){
        matches.put(match.getId(), match);
    }

    public Match getMatchById(String matchId){
        return matches.get(matchId);
    }
}
