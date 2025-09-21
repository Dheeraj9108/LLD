package PubSubLLD;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import PubSubLLD.entites.Message;
import PubSubLLD.entites.Topic;
import PubSubLLD.subscribers.Subscriber;

public class PubSubSystem {
    private static PubSubSystem INSTANCE;
    private ExecutorService deleveryExecutor;
    private Map<String,Topic> topics;

    private PubSubSystem(){
        topics = new HashMap<>();
        deleveryExecutor = Executors.newCachedThreadPool();
    }

    public static PubSubSystem getInstance(){
        if(INSTANCE == null){
            synchronized(PubSubSystem.class){
                if(INSTANCE == null){
                    INSTANCE = new PubSubSystem();
                }
            }
        }
        return INSTANCE;
    }

    public void createTopic(String name){
        topics.putIfAbsent(name, new Topic(name,deleveryExecutor));
    }

    public void subscribe(String topicName, Subscriber subscriber){
        Topic topic = topics.get(topicName);
        topic.addSubscriber(subscriber);
    }

    public void unSubscribe(String topicName, Subscriber subscriber){
        Topic topic = topics.get(topicName);
        topic.removeSubscriber(subscriber);
    }

    public void publish(String topicName,Message message){
        Topic topic = topics.get(topicName);
        topic.broadCastMessage(message);
    }

    public void shutdown(){
        deleveryExecutor.shutdown();
        try {
            if(!deleveryExecutor.awaitTermination(60, TimeUnit.SECONDS)){
                deleveryExecutor.shutdownNow();
            }
        } catch (Exception e) {
            deleveryExecutor.shutdownNow();
        }
    }
}
