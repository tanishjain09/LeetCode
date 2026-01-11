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
    int camera = 0;
    private int solve(TreeNode node){
        if(node == null) return 1;

        int l = solve(node.left);
        int r = solve(node.right);
        if(l == 0 || r == 0){
            camera++;
            return 2;
        }
        if(l == 2 || r == 2){
            return 1;
        }
        return 0;
    }
    public int minCameraCover(TreeNode root) {
        return solve(root) == 0 ? camera+1: camera;
    }
}