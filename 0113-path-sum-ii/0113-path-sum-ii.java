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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, ans, new ArrayList<>());
        return ans;
    }
    private void dfs(TreeNode root, int target, List<List<Integer>> ans, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        if(target == root.val && root.right == null && root.left == null){
            ans.add(new ArrayList<>(list));
        }
        dfs(root.left, target - root.val, ans, list);
        dfs(root.right, target - root.val, ans, list);
        
        list.remove(list.size() - 1);
    }
}