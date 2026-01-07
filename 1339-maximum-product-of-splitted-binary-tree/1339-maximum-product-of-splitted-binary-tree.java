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
    long max = 0;
    int MOD = (int)1000000000+7;
    public int maxProduct(TreeNode root) {
        long total = totalSum(root);
        dfs(root, total);
        return (int)(max % MOD);
    }
    private long dfs(TreeNode root, long total){
        if(root == null) return 0;
        long left = dfs(root.left, total);
        long right = dfs(root.right, total);
        long subtreeSum = left + right + root.val;

        long product = subtreeSum * (total - subtreeSum);
        max = Math.max(max, product);
        return subtreeSum;
    }
    private long totalSum(TreeNode root){
        if(root == null) return 0;

        long left = totalSum(root.left);
        long right = totalSum(root.right);
        return root.val + left + right;
    }
}