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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = leftHeight(root);
        int right = rightHeight(root);

        if(left == right) return (int)Math.pow(2, left) -1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    } 
    private int leftHeight(TreeNode root){
        int length = 0;
        while(root!=null){
            length++;
            root = root.left;
        }
        return length;
    }
    private int rightHeight(TreeNode root){
        int length = 0;
        while(root!=null){
            length++;
            root = root.right;
        }
        return length;
    }
}