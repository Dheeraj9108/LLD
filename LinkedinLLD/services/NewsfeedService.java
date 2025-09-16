package LinkedinLLD.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LinkedinLLD.entites.Member;
import LinkedinLLD.entites.Post;
import LinkedinLLD.stratergy.FeedSortStratergy;

public class NewsfeedService {
    
    private Map<String,List<Post>> posts;

    public NewsfeedService(){
        posts = new HashMap<>();    
    }

    public void addPost(Post post){
        Member author = post.getAuhtor();
        if(!posts.containsKey(author.getId())){
            posts.put(author.getId(), new ArrayList<>());
        }
        posts.get(author.getId()).add(post);
    }

    public List<Post> getMemberPosts(Member member){
        return posts.getOrDefault(member.getId(), new ArrayList<>());
    }

    public List<Post> displayMemberFeed(Member member, FeedSortStratergy feedSortStratergy){
        List<Post> feed  = new ArrayList<>(posts.get(member.getId()));
        for(Member connection: member.getConections()){
            List<Post> connectionPosts = posts.getOrDefault(connection.getId(), new ArrayList<>());
            feed.addAll(connectionPosts); 
        }
        return feedSortStratergy.sort(feed);
    }

}
