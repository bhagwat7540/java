package stackoverflow.strategies;

import stackoverflow.entities.Question;
import stackoverflow.entities.User;

import java.util.List;

public class UserSearchStrategy implements SearchStrategy {
    private final User user;

    public UserSearchStrategy(User user) {
        this.user = user;
    }

    @Override
    public List<Question> find(List<Question> questions) {
        return questions.stream().filter(q -> q.getAuthor().getId().equals(user.getId())).toList();
    }
}
