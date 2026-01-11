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
    HashMap<TreeNode, Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(dp.containsKey(root)){
            return dp.get(root);
        }
        int take = root.val;
        if(root.left!=null && root.left.left!=null){
            take += rob(root.left.left);
        }
        if(root.left != null && root.left.right !=null){
            take += rob(root.left.right); 
        }
        if(root.right!=null && root.right.right != null){
            take += rob(root.right.right);
        }
        if(root.right != null && root.right.left!=null){
            take += rob(root.right.left);
        }

        int notTake = rob(root.left) + rob(root.right);
        int ans = Math.max(take, notTake);
        dp.put(root, ans);
        return ans;
    }
}