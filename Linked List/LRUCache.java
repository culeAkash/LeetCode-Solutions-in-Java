class LRUCache {
    Node head,tail;
    Map<Integer,Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
         head= new Node(0,0);
         tail = new Node(0,0);
         head.next = tail;
         tail.prev = head;
         map = new HashMap<>();
        this.capacity = capacity; 
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        
        Node t = map.get(key);
         t.next.prev = t.prev;
        t.prev.next = t.next;
        t.next = null;
        t.prev= null;
        
        t.next = head.next;
        t.prev = head;
        head.next = t;
        t.next.prev = t;
        
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size()== capacity){
                map.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }
            //put the new node to the DLL
            
            Node newNode = new Node(key,value);
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
            
            map.put(key,newNode);
        }
        else{
            get(key);
            head.next.val = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class Node{
    int key;
    int val;
    Node prev=null;
    Node next=null;
    
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
    
}
