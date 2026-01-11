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
    private void buildGraph(TreeNode node, TreeNode parent,Map<Integer, List<Integer>> adjList){
        if(node == null ) return;
        adjList.putIfAbsent(node.val, new ArrayList<>());

        if(parent!=null){
            adjList.putIfAbsent(parent.val, new ArrayList<>());
            adjList.get(parent.val).add(node.val);
            adjList.get(node.val).add(parent.val);
        }
        buildGraph(node.left, node, adjList);
        buildGraph(node.right, node, adjList);
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        buildGraph(root, null,adjList);
        
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis.add(start);
        int time = -1;
        
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int i = 0; i < size; i++){
                int node = q.poll();
                for(int adjNode : adjList.get(node)){
                    if(!vis.contains(adjNode)){
                        vis.add(adjNode);
                        q.add(adjNode);
                    }
                }
            }
        }
        return time;
    }
}