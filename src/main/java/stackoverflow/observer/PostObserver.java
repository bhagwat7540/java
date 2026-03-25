package stackoverflow.observer;

import stackoverflow.entities.Event;

public interface PostObserver {
    public void update(Event event);
}
