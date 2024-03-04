class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
        this.tail = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)){
            Node node = map.get(key);
            result = node.value;
            removeNode(node);
            addNode(node);
            map.put(key, node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            map.remove(key);
            removeNode(curr);
        }
        if(map.size() == capacity){
            Node curr = map.get(tail.prev.key);
            map.remove(curr.key);
            removeNode(curr);
        }
        
        addNode(new Node(key, value));
        map.put(key, head.next);
    }
    
    void addNode(Node newNode){
        Node temp = head.next;
    
        newNode.next = temp;
        newNode.prev = head;
        
        temp.prev = newNode;
        head.next = newNode;
    }
    
    void removeNode(Node deleteNode){
        Node prevNode = deleteNode.prev;
        Node nextNode = deleteNode.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */