import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import entites.Answer;
import entites.Comment;
import entites.Post;
import entites.Question;
import entites.Tag;
import entites.User;
import enums.VoteType;
import observer.ReputationManager;
import stratergy.SearchStratergy;

public class StackoverflowService {
    private static StackoverflowService instance;
    private Map<String, User> userMap;
    private Map<String, Question> questionMap;
    private Map<String, Answer> answerMap;
    private ReputationManager reputationManager;

    private StackoverflowService(){
        userMap = new HashMap<>();
        questionMap = new HashMap<>();
        answerMap = new HashMap<>();
        reputationManager = new ReputationManager();
    }

    public static StackoverflowService getInstance(){
        if(instance == null){
            synchronized(StackoverflowService.class){
                if(instance == null){
                    instance = new StackoverflowService();
                }
            }
        }
        return instance;
    }

    public User createUser(String name){
        User user = new User(name);
        userMap.put(user.getId(), user);
        return user;
    }

    public Question postQuestion(String title,String question, String userId, Set<Tag> tags){
        User user = userMap.get(userId);
        Question q = new Question(question, user, title, tags);
        q.addObservers(reputationManager);
        questionMap.put(q.getId(),q);
        return q;
    }

    public Answer postAnswer(String body, String questionId, String userId){
        Question q = questionMap.get(questionId);
        User user = userMap.get(userId);
        Answer answer = new Answer(body, user);
        q.addAnswer(answer);
        answer.addObservers(reputationManager);
        answerMap.put(answer.getId(), answer);
        return answer;
    }

    public Comment addComment(String body, String userId, String postId){
        Post post = getPost(postId);
        User user = userMap.get(userId);
        Comment comment = new Comment(body, user);
        post.addComment(comment);
        return comment;
    }

    public void vote(String userId, String postId, VoteType voteType){
        Post post =  getPost(postId);
        User user = userMap.get(userId);
        post.vote(user, voteType);
    }

    public List<Question> search(List<SearchStratergy> stratergies){
        List<Question> result = new ArrayList<>(questionMap.values());
        for(SearchStratergy stratergy : stratergies){
            result = stratergy.search(result);
        }
        return result;
    }

    private Post getPost(String postId){
        if(questionMap.containsKey(postId)) return questionMap.get(postId);
        else if (answerMap.containsKey(postId)) return answerMap.get(postId);
        else throw new NoSuchElementException("No User Found");
    }
}
