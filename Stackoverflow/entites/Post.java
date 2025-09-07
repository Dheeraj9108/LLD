package entites;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.EventType;
import enums.VoteType;
import observer.PostObserver;

public abstract class Post extends Content{

    int voteCnt;
    List<Comment> comments;
    Map<String, VoteType> voters;
    List<PostObserver> observers;
    
    public Post(String body, User author) {
        super(body, author);
        observers = new ArrayList<>();
        comments = new ArrayList<>();
        voters = new HashMap<>();
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void addObservers(PostObserver observer){
        observers.add(observer);
    }

    protected void notifyObservers(User user,EventType eventType){
        observers.forEach(observer-> observer.update(user, eventType));
    }

    public void vote(User user, VoteType voteType){
        int score = 0;
        if(voters.containsKey(user.getId())){
            if(voters.get(user.getId()).equals(voteType)) return;
            else {
                score = voteType == VoteType.UPVOTE ? 2 : -2;
            }
        } else {
            score = voteType == VoteType.UPVOTE ? 1 : -1;
        }
        voters.put(user.getId(), voteType);
        voteCnt+=score;

        EventType eventType = EventType.UPVOTE_QUESTION;

        if(this instanceof Question){
            eventType = voteType == VoteType.UPVOTE ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION;
        } else {
            eventType = voteType == VoteType.UPVOTE ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER;
        }

        notifyObservers(author,eventType);
    }
}
