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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode headSecond = reverse(mid);
        ListNode reverseHead = headSecond;

        while(head != null && headSecond !=null){
            if(head.val != headSecond.val) break;
            head = head.next;
            headSecond = headSecond.next;
        }

        reverse(reverseHead);
        if(head==null || headSecond == null){
            return true;
        }
        return false;
    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
}