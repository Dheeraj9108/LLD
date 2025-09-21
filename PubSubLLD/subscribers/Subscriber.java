package PubSubLLD.subscribers;

import PubSubLLD.entites.Message;

public interface Subscriber {
    public String getId();
    public void onMessage(Message message); 
}
