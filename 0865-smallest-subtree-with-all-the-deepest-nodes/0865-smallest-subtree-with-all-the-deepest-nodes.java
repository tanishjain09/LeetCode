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
    TreeNode node = null;
    int deepest = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root, 0);
        return node;
    }
    private int helper(TreeNode root, int level){
        if(root == null) return level;

        int leftLevel = helper(root.left, level+1);
        int rightLevel = helper(root.right, level+1);

        int curr = Math.max(leftLevel, rightLevel);
        deepest =  Math.max(deepest, curr);
        if(leftLevel == deepest && rightLevel == deepest) node = root;
        return curr;
    }
}