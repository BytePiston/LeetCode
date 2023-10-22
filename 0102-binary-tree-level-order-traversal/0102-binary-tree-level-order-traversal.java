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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)    
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //Add 1st list
        List<Integer> list = new ArrayList<>(1);
        list.add(root.val);
        result.add(list);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> child = new LinkedList<>();
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                    child.add(node.left.val);
                }
                if(node.right != null){
                    queue.offer(node.right);
                    child.add(node.right.val);
                }
            }
            if(!child.isEmpty())
                    result.add(child);
        }
        return result;
    }
}