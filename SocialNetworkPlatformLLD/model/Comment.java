package SocialNetworkPlatformLLD.model;

import java.util.List;

public class Comment extends Commentable{

    public Comment(User author, String content) {
        super(author, content);
    }
    
    public List<Comment> getReply(){
        return getComments();
    }
}
