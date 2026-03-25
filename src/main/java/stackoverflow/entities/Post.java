package stackoverflow.entities;

import stackoverflow.enums.EventType;
import stackoverflow.enums.VoteType;
import stackoverflow.observer.PostObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Post {
    private final String id;
    private final User author;
    private String title;
    private String description;
    private final List<Vote> votes;
    private final List<PostObserver> observers;

    public Post(User author, String title, String description) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.title = title;
        this.description = description;
        this.votes = new ArrayList<>();
        this.observers = new CopyOnWriteArrayList<>();
    }

    public String getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void addObserver(PostObserver observer) {
        observers.add(observer);
    }

    public void notifyObserver(Event event) {
        for (PostObserver observer : observers) {
            observer.update(event);
        }
    }

    public synchronized void vote(User user, VoteType voteType) {
        EventType eventType;

        this.votes.add(new Vote(user, voteType));

        if(this instanceof Question) eventType = EventType.QUESTION_UPVOTE;
        else eventType = EventType.ANSWER_DOWNVOTE;

        this.notifyObserver(new Event(eventType, user, this));
    }
}
