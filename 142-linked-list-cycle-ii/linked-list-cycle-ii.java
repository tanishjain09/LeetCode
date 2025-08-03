/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = cycleLength(head);
        if(length == 0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        while(length > 0){
            slow = slow.next;
            length--;
        }
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    private int cycleLength(ListNode head){
        ListNode f = head;
        ListNode s = head;

        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s==f){
                int length=0;
                do{
                    s=s.next;
                    length++;
                }while(s!=f);
                return length;
            }
        }
        return 0;
    }
}