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
    int deepest = 0;
    TreeNode res = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public int dfs(TreeNode root, int level){
        if(root == null) return level;

        int leftLevel = dfs(root.left, level+1);
        int rightLevel = dfs(root.right, level+1);
        int curr = Math.max(leftLevel, rightLevel);
        deepest = Math.max(deepest, curr);
        if(leftLevel == deepest && rightLevel == deepest) res = root;
        return curr;
    }
}