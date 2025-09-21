package PubSubLLD;

import PubSubLLD.entites.Message;
import PubSubLLD.subscribers.NewsSubscriber;

public class PubSubLLDMain {
    public static void main(String[] args)throws InterruptedException {
        PubSubSystem pubSubSystem = PubSubSystem.getInstance();

        pubSubSystem.createTopic("Java");

        NewsSubscriber  s1 = new NewsSubscriber("s1");
        NewsSubscriber  s2 = new NewsSubscriber("s2");
        NewsSubscriber  s3 = new NewsSubscriber("s3");

        pubSubSystem.subscribe("Java", s1);
        pubSubSystem.subscribe("Java", s2);
        pubSubSystem.subscribe("Java", s3);

        pubSubSystem.publish("Java", new Message("What is Java"));
        Thread.sleep(500);
        pubSubSystem.unSubscribe("Java", s3);
        pubSubSystem.publish("Java", new Message("What is OOP"));
        pubSubSystem.shutdown();
    }    
}
