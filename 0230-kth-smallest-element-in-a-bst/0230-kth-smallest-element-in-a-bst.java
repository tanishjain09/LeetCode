/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        helper(root, k, minHeap);
        int ans = 0;
        for(int i = 0; i < k; i++){
            ans = minHeap.poll();
        }
        return ans;
    }

    private void helper(TreeNode root, int k, PriorityQueue<Integer> minHeap){
        if(root == null) return;
        helper(root.left, k, minHeap);
        minHeap.offer(root.val);
        helper(root.right, k, minHeap);
    }
}