package LinkedinLLD.services;

import java.util.HashMap;
import java.util.Map;

import LinkedinLLD.entites.Connection;
import LinkedinLLD.entites.Member;
import LinkedinLLD.entites.Notification;
import LinkedinLLD.enums.Connectiontype;
import LinkedinLLD.enums.NotificationType;

public class ConnectionService {
    
    private Map<String,Connection> connections;
    private NotificationService notificationService;

    public ConnectionService(){
        this.connections = new HashMap<>();
        this.notificationService = new NotificationService();
    }     

    public String requestConnect(Member from, Member to){
        Connection connection = new Connection(from,to);
        connections.put(connection.getId(), connection);

        Notification notification = new Notification("Connection Request form: "+from.getName(), NotificationType.CONNECTION_REQUEST, to.getId());
        this.notificationService.send(to, notification);
        return connection.getId();
    }

    public void acceptRequest(String connectionId){
        if(!connections.containsKey(connectionId)){
            System.out.println("No Connection Found");
            return;
        }
        Connection conn = connections.get(connectionId);
        Member from  = conn.getFrom();
        Member to = conn.getTo();

        conn.setStatus(Connectiontype.ACCETED);
        
        from.addConnection(to);
        to.addConnection(from);

        Notification notification = new Notification(to.getName()+" Accepted Connection Request", NotificationType.CONNECTION_REQUEST, from.getId());
        this.notificationService.send(from, notification);
        connections.remove(connectionId);
    }
}
