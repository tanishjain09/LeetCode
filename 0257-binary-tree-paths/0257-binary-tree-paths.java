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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        solve(root, res, new StringBuilder());
        return res;
    }
    private void solve(TreeNode root, List<String> res, StringBuilder str){
        if(root == null) return;

        int len = str.length(); //will be use in backtraking
        str.append(root.val);
        if(root.left == null && root.right == null) res.add(str.toString());
        str.append("->");
        solve(root.left, res, str);
        solve(root.right, res, str);

        str.setLength(len);
    }
}