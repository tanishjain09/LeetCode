/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        copyInBetween(head);
        connectRandom(head);
        return getDeepCopy(head);
    }
    private void copyInBetween(Node head){
        Node temp = head;
        while(temp!=null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
    }
    private void connectRandom(Node head){
        Node temp = head;
        while(temp!=null){
            Node copy = temp.next;
            if(temp.random == null) copy.random = null;
            else copy.random = temp.random.next;
            temp = temp.next.next;
        }
    }
    private Node getDeepCopy(Node head){
        Node dummy = new Node(0);
        Node res = dummy;
        Node temp = head;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}