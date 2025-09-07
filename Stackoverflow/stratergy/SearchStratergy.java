package stratergy;

import java.util.List;

import entites.Question;

public interface SearchStratergy {
    List<Question> search(List<Question> questions);
}
