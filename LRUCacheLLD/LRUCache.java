package LRUCacheLLD;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {
    int capacity;
    Map<K,Node<K,V>> nodes;
    DoublyLinkedList<K,V> ddl;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
        nodes = new HashMap<>();
        ddl = new DoublyLinkedList<>();
    }

    public void put(K key, V value){
        if(nodes.containsKey(key)){
            Node<K,V> node = nodes.get(key);
            ddl.moveToFront(node);
        } else {
            if(capacity == 0){
                Node<K,V> last = ddl.removeLast();
                nodes.remove(last.key);
            }
            Node<K,V> node = new Node<K,V>(key, value);
            ddl.addFirst(node);
            nodes.put(key, node);
            capacity--;
        }
    }

    public V get(K key){
        if(!nodes.containsKey(key)){
            System.out.println("Node not found");
            return null;
        }
        Node<K,V> node = nodes.get(key);
        ddl.moveToFront(node);
        return node.value;
    }

    public void remove(K key){
        if(nodes.containsKey(key)){
            Node<K,V> node = nodes.get(key);
            nodes.remove(key);
            ddl.remove(node);
        }
    }
}
