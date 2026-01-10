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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : to_delete) set.add(num);
        List<TreeNode> res = new ArrayList<>();
        root = helper(root, set, res);
        if(root != null) res.add(root);
        return res;
    }
    private TreeNode helper(TreeNode root, HashSet<Integer> set, List<TreeNode> res){
        if(root==null) return null;
        

        //postorder traversal
        root.left = helper(root.left, set, res);
        root.right = helper(root.right, set, res);

        if(set.contains(root.val)){
            if(root.left != null) res.add(root.left);
            if(root.right != null) res.add(root.right);
            return null; // stored the left and right now delete the node means return null for curr node
        }
        return root;
    }
}