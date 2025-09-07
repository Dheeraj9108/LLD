package entites;

import java.util.Date;
import java.util.UUID;

public abstract class Content {
    String id;
    User author;
    Date createdDate;
    String body;

    public Content(String body, User author){
        id = UUID.randomUUID().toString();
        this.createdDate = new Date();
        this.body = body;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
}
