package stackoverflow.entities;

import stackoverflow.enums.EventType;

public class Event {
    private final EventType eventType;
    private final User user;
    private final Post post;

    public Event(EventType eventType, User user, Post post) {
        this.eventType = eventType;
        this.user = user;
        this.post = post;
    }

    public EventType getEventType() {
        return eventType;
    }

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }
}
