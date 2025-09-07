import java.util.List;
import java.util.Set;

import entites.Answer;
import entites.Question;
import entites.Tag;
import entites.User;
import enums.VoteType;
import stratergy.KeywordStratergy;
import stratergy.SearchStratergy;

public class StackoverflowLLDMain {
    public static void main(String[] args) {
        StackoverflowService service = StackoverflowService.getInstance();
        
        User alice = service.createUser("Alice");
        User bob = service.createUser("Bob");
        User jerry = service.createUser("Jerry");

        Set<Tag> tags = Set.of(new Tag("Java"),new Tag("LLD"));
        Question aliceQ = service.postQuestion("What is Java", "What is Java? How it helps in LLD", alice.getId(), tags);
        
        Answer bobAnswer = service.postAnswer("Java is a programing Language", aliceQ.getId(), bob.getId());

        Answer jerryAnswer = service.postAnswer("Java is Object Oriented Programming Language", aliceQ.getId(), jerry.getId());

        service.addComment("Good Question", bob.getId(), aliceQ.getId());

        service.vote(alice.getId(), aliceQ.getId(), VoteType.UPVOTE);

        service.vote(jerry.getId(), bobAnswer.getId(), VoteType.UPVOTE);

        service.vote(bob.getId(), jerryAnswer.getId(), VoteType.DOWNVOTE);

        aliceQ.setAcceptedAnswer(bobAnswer);

        printReputation(alice,bob,jerry);

        List<SearchStratergy> stratergies = List.of(new KeywordStratergy("Java")); 
        List<Question> result = service.search(stratergies);
        result.forEach(item->System.out.println(item.getTitle()));
    }

    public static void printReputation(User... users) {
        for(User user : users){
            System.out.println("Reputation " + user.getName() + " -> "+ user.getReputation());
        }
    }
}
