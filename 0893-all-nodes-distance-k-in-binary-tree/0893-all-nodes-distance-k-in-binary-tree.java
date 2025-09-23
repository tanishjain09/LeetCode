/**
 * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParent(root, parentTrack);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(level == k) break;
            level++;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                while (curr.left!=null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                while (curr.right!=null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                while (parentTrack.get(curr)!=null && !visited.contains(parentTrack.get(curr))){
                    q.offer(parentTrack.get(curr));
                    visited.add(parentTrack.get(curr));
                }
            }   
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            list.add(curr.val);
        }
        return list;
    }

    private void markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                parentTrack.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parentTrack.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

}