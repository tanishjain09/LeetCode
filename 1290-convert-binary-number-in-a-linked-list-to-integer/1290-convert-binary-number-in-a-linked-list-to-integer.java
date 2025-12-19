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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int num = 0;
        int i = 0;
        while(temp!=null){
            i++;
            temp = temp.next;
        }
        int len = i-1;
        temp = head;
        while(temp!=null){
            num = num + (int)(Math.pow(2, len) * temp.val);
            temp = temp.next;
            len--;
        }
        return num;
    }
}