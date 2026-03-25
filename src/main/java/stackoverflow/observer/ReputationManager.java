package stackoverflow.observer;

import stackoverflow.entities.Event;
import stackoverflow.entities.User;

public class ReputationManager implements PostObserver {
    @Override
    public void update(Event event) {
        User user = event.getUser();
        user.updateReputation(event.getEventType().getPoints());
    }
}
