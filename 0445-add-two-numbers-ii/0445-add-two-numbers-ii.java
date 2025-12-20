/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode h1 = reverse(l1);
        ListNode h2 = reverse(l2);
        int carry = 0;
        while(h1!=null || h2 != null){
            int sum = carry;
            if(h1!=null){
                sum+=h1.val;
                h1 = h1.next;
            }
            if(h2!=null){
                sum+=h2.val;
                h2 = h2.next;
            }
            ListNode temp1 = new ListNode(sum%10);
            carry = sum/10;
            temp.next = temp1;
            temp = temp1;
        }
        if(carry > 0){
            temp.next =new ListNode(carry);
        }
        return reverse(dummy.next);
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}