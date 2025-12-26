
class Node{
    int key, value, cnt;
    Node next;
    Node prev;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        cnt = 1;
    }
}
class DLL{
    int size;
    Node head;
    Node tail;
    public DLL(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    void addFront(Node node){
        Node currHeadNext = head.next;
        node.next = currHeadNext;
        head.next = node;
        node.prev = head;
        currHeadNext.prev = node;
        size++;
    }
    void delete(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}
class LFUCache {

    private HashMap<Integer, Node> keyNode;
    private HashMap<Integer, DLL> freqList;
    private int minFreq, maxSize, curSize;

    public LFUCache(int capacity) {
        keyNode = new HashMap<>();
        freqList = new HashMap<>();
        minFreq = 0;
        maxSize = capacity;
        curSize = 0;
    }

    private void updateFreqListMap(Node node) {
        keyNode.remove(node.key);

        DLL oldList = freqList.get(node.cnt);
        oldList.delete(node);

        if (node.cnt == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.cnt++;

        DLL newList = freqList.getOrDefault(node.cnt, new DLL());
        newList.addFront(node);
        freqList.put(node.cnt, newList);

        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) return -1;

        Node node = keyNode.get(key);
        updateFreqListMap(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (maxSize == 0) return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {
            if (curSize == maxSize) {
                DLL list = freqList.get(minFreq);
                Node toRemove = list.tail.prev;
                list.delete(toRemove);
                keyNode.remove(toRemove.key);
                curSize--;
            }

            curSize++;
            minFreq = 1;

            Node node = new Node(key, value);
            DLL list = freqList.getOrDefault(1, new DLL());
            list.addFront(node);
            freqList.put(1, list);
            keyNode.put(key, node);
        }
    }
}
