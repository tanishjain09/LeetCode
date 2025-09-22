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
    class Pair{
        TreeNode node;
        int line;
        int level;

        Pair(TreeNode node, int line, int level) {
            this.node = node;
            this.line = line;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int line = pair.line;
            int level = pair.level;
            map.putIfAbsent(line, new ArrayList<>());
            map.get(line).add(new int[]{node.val, level});

            if(node.left != null) q.add(new Pair(node.left, line-1, level+1));
            if(node.right != null) q.add(new Pair(node.right, line+1, level+1));
        }
        for(List<int[]> list : map.values()){
            Collections.sort(list, (a,b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> vertical = new ArrayList<>();
            for(int[] pair : list) vertical.add(pair[0]);
            ans.add(vertical);
        }
        
        return ans;
    }
}