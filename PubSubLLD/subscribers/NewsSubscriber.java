package PubSubLLD.subscribers;

import PubSubLLD.entites.Message;

public class NewsSubscriber implements Subscriber{

    private final String id;

    public NewsSubscriber(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }   

    @Override
    public void onMessage(Message message) {
        System.out.printf("Subscriber %s received %s\n", id,message.getPayload());
    }
    
}
