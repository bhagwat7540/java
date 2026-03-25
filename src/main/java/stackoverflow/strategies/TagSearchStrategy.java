package stackoverflow.strategies;

import stackoverflow.entities.Question;
import stackoverflow.entities.Tag;

import java.util.List;

public class TagSearchStrategy implements SearchStrategy{
    private final Tag tag;

    public TagSearchStrategy(Tag tag) {
        this.tag = tag;
    }

    @Override
    public List<Question> find(List<Question> questions) {
        return questions.stream().filter(q -> q.getTags().stream().anyMatch(t -> t.getName().equals(tag.getName()))).toList();
    }
}
