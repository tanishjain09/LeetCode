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
        int length = findHeight(head);
        if(length == 0){
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while(length > 0){
            ptr1 = ptr1.next;
            length--;
        }

        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    
    }
    private int findHeight(ListNode head){
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(s == f){
                int length = 0;
                do{
                    s = s.next;
                    length++;
                }while(s!=f);
                return length;
            }
        }
        return 0;
    }
}