package entites;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import enums.EventType;

public class Question extends Post{
    String title;
    List<Answer> answers;
    Set<Tag> tags;
    Answer acceptedAnswer;
    public Question(String body, User author, String title, Set<Tag> tags) {
        super(body, author);
        answers = new ArrayList<>();
        this.tags = tags;
        acceptedAnswer = null;
        this.title = title;
    }

    public void setAcceptedAnswer(Answer answer){
        if(acceptedAnswer == null){
            acceptedAnswer = answer;
            notifyObservers(answer.getAuthor(), EventType.ACCEPT_ANSWER);
            return;
        }
        System.out.println("Only one Answer can be acepted");
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public String getTitle(){
        return title;
    }
}
