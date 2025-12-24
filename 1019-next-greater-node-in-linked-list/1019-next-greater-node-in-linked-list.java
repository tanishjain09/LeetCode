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
    int n = 0;
    public int[] nextLargerNodes(ListNode head) {
        ListNode reverseHead = reverse(head);
        ListNode temp = reverseHead;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        int i = 0;
        while(temp!=null){
            while(!st.isEmpty() && st.peek() <= temp.val){
                st.pop();
            }
            if(st.isEmpty()) ans[i++] = 0;
            else ans[i++] = st.peek();
            st.push(temp.val);
            temp = temp.next;
        }
        reverseArray(ans, 0, n-1);
        return ans;
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n++;
        }
        return prev;
    }
    private void reverseArray(int[] arr, int i,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}