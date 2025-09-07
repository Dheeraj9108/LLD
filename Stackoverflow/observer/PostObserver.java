package observer;

import entites.User;
import enums.EventType;

public interface PostObserver {
    public void update(User user, EventType eventType);
}
