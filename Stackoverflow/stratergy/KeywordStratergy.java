package stratergy;

import java.util.List;
import java.util.stream.Collectors;

import entites.Question;

public class KeywordStratergy implements SearchStratergy {

    private final String key;

    public KeywordStratergy(String key) {
        this.key = key;
    }

    @Override
    public List<Question> search(List<Question> questions) {
        return questions.stream()
        .filter(item-> item.getBody().contains(this.key) || item.getTitle().contains(key))
        .collect(Collectors.toList());
    }

}
