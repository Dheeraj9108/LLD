package LinkedinLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LinkedinLLD.entites.Member;
import LinkedinLLD.entites.Post;
import LinkedinLLD.services.ConnectionService;
import LinkedinLLD.services.NewsfeedService;
import LinkedinLLD.services.SearchService;
import LinkedinLLD.stratergy.ChronicalsortStratergy;

public class LinkedinSystem {
    private static LinkedinSystem INSTANCE;
    private Map<String,Member> members;
    private ConnectionService conncetionService;
    private NewsfeedService feedService;
    private SearchService searchService;

    private LinkedinSystem(){
        this.members = new HashMap<>();
        conncetionService = new ConnectionService();
        feedService = new NewsfeedService();
        searchService = new SearchService();
    }

    public static LinkedinSystem getInstance(){
        if(INSTANCE == null){
            synchronized(LinkedinSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new LinkedinSystem();
                }
            }
        }
        return INSTANCE;
    }
    
    public void register(Member member){
        members.put(member.getId(),member);
    }

    public String sendConnection(Member from , Member to){
        return conncetionService.requestConnect(from, to);
    }

    public void acceptRequest(String connectionId){
        conncetionService.acceptRequest(connectionId);
    }

    public Post createPost(String content, Member member){
        Post post = new Post(member, content);
        feedService.addPost(post);
        return post;
    }

    public Post getMemberLatestPost(Member member){
        List<Post> memberPost = feedService.getMemberPosts(member);
        return memberPost.get(memberPost.size()-1);
    }

    public void viewFeed(Member member){
        List<Post> posts = feedService.displayMemberFeed(member, new ChronicalsortStratergy());
        for(Post post : posts){
            post.display();
        }
    }

    public void searchByName(String key){
        List<Member> filteredMembers = searchService.searchByName(new ArrayList<>(members.values()), key);
        for(Member member: filteredMembers){
            member.display();
        }
    }
}
