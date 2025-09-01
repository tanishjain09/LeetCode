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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return result;

        queue.offerFirst(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                if(!reverse){
                    TreeNode currentNode = queue.pollFirst();
                    row.add(currentNode.val);
                    if(currentNode.left  != null) queue.offerLast(currentNode.left);
                    if(currentNode.right  != null) queue.offerLast(currentNode.right);
                }else{
                    TreeNode currentNode = queue.pollLast();
                    row.add(currentNode.val);
                    if(currentNode.right  != null) queue.offerFirst(currentNode.right);
                    if(currentNode.left  != null) queue.offerFirst(currentNode.left);
                }
            }
            reverse = !reverse;
            result.add(row);
        }
        return result;
    }
}