package stackoverflow.strategies;

import stackoverflow.entities.Question;
import java.util.List;

@FunctionalInterface
public interface SearchStrategy {
    public List<Question> find(List<Question> questions);
}
