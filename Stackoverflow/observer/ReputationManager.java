package observer;

import entites.User;
import enums.EventType;

public class ReputationManager implements PostObserver {

    private final int UPVOTE_ANSWER = 2;
    private final int UPVOTE_QUESTION = 2;
    private final int DOWNVOTE_ANSWER = -1;
    private final int DOWNVOTE_QUESTION = -1;
    private final int ACCEPT_ANSWER = 5;

    @Override
    public void update(User user, EventType eventType) {
        switch (eventType) {
            case UPVOTE_ANSWER:
                user.setReputaion(UPVOTE_ANSWER);
                break;
            case DOWNVOTE_ANSWER:
                user.setReputaion(DOWNVOTE_ANSWER);
                break;
            case UPVOTE_QUESTION:
                user.setReputaion(UPVOTE_QUESTION);
                break;
            case DOWNVOTE_QUESTION:
                user.setReputaion(DOWNVOTE_QUESTION);
                break;
            case ACCEPT_ANSWER:
                user.setReputaion(ACCEPT_ANSWER);
                break;
            default:
                break;
        }
    }

}
