package stackoverflow;

import stackoverflow.entities.*;
import stackoverflow.enums.VoteType;
import stackoverflow.observer.ReputationManager;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflowService {
    private final Map<String, User> users;
    private final Map<String, Question> questions;
    private final Map<String, Answer> answers;
    private final ReputationManager reputationManager;

    public StackOverflowService() {
        this.users = new ConcurrentHashMap<>();
        this.questions = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.reputationManager = new ReputationManager();
    }

    public User addUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Question addQuestion(String userId, String title, String description, Set<Tag> tags) {
        Question question = new Question(users.get(userId), title, description, tags);
        questions.put(question.getId(), question);

        question.addObserver(reputationManager);

        return question;
    }

    public Answer postAnswer(String userId, String title, String description, String questionsId) {
        Answer answer = new Answer(users.get(userId), title, description);
        Question question = questions.get(questionsId);
        question.getAnswers().add(answer);

        answers.put(answer.getId(), answer);
        answer.addObserver(reputationManager);

        return answer;
    }

    public void voteOnPost(String postId, VoteType voteType) {
        Post post = this.findPostById(postId);
        post.vote(users.get(post.getAuthor().getId()), voteType);
    }

    public User getUser(String id) {
        return this.users.get(id);
    }

    public Question getQuestion(String id) {
        return this.questions.get(id);
    }

    public Answer getAnswer(String id) {
        return this.answers.get(id);
    }

    private Post findPostById(String id) {
        if (questions.containsKey(id)) return questions.get(id);
        else if (answers.containsKey(id)) return answers.get(id);
        else throw new NoSuchElementException("Post id not present");
    }

}
