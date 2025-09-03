class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int cap;
    private Map<Integer, Node> mpp;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.mpp = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(mpp.containsKey(key)){
            Node node = mpp.get(key);
            deleteNode(node);
            insertAfterHead(node);
            return node.val;
        }
        return -1;
    }

    private void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    private void insertAfterHead(Node node){
        Node currentHead = head.next;
        head.next = node;
        node.next = currentHead;
        node.prev = head;
        currentHead.prev = node;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node node = mpp.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(mpp.size() == cap){
                Node node = tail.prev;
                mpp.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key, value);
            mpp.put(key, node);
            insertAfterHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */