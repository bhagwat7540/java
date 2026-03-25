package stackoverflow.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Question extends Post {
    private final List<Answer> answers;
    private final Set<Tag> tags;

    public Question(User author, String title, String description, Set<Tag> tags) {
        super(author, title, description);
        this.answers = new ArrayList<>();
        this.tags = tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Set<Tag> getTags() {
        return tags;
    }
}
