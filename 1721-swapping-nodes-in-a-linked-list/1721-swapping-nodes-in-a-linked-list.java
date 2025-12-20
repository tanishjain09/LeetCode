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
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        temp = head;
        int i = 1;
        ListNode fromStart = head;
        while(i <= k){
            if(i == k) fromStart = temp;
            temp = temp.next;
            i++;
        }
        temp = head;
        int j = 1;
        ListNode fromEnd = null;
        while(j <= size - k + 1){
            if(j == size-k+1) fromEnd = temp;
            temp = temp.next;
            j++;
        }
        int temp1 = fromStart.val;
        fromStart.val = fromEnd.val;
        fromEnd.val = temp1;
        return head;
    }
}