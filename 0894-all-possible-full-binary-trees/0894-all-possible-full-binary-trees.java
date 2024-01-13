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
    public List<TreeNode> allPossibleFBT(int n) {        
        return solveMemoized(n, new HashMap<>());
    }
    
    //  Recursive with Memoization Solution;
    List<TreeNode> solveMemoized(int n, Map<Integer, List<TreeNode>> memo){
        List<TreeNode> result = new ArrayList<>();
        
        //  Since FBT CAN NOT have "Even" No. of Nodes returing Empty List back to caller;
        if(n == 0 || n%2 == 0){
            return result;
        }
        
        //  If we have already encounterd the N before for which we have generated the combinations of Tress; Return from Map;
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        
        //  Base case where N == 1; we create root node only with left and right child as NULL and add it to result list;
        if(n == 1){
            TreeNode node = new TreeNode(0);
            node.left = null;
            node.right = null;
            result.add(node);
        }
        
        for(int i=1; i<n; i+=2){
            //  Creating the different combinations of Left and Right sub-trees for all "Odd" values of "i";
            //  If I can create "i" Left Sub-Trees then it means I can only create "n-i-1" Right Sub-Trees because 1 will be for Main Root Node.
            List<TreeNode> leftTrees = solveMemoized(i, memo);
            List<TreeNode> rightTrees = solveMemoized(n-i-1, memo);
            
            for(int left=0; left<leftTrees.size(); left++){
                for(int right=0; right<rightTrees.size(); right++){
                    TreeNode node = new TreeNode(0);
                    node.left = leftTrees.get(left);
                    node.right = rightTrees.get(right);
                    result.add(node);
                }
            }
        }
        memo.put(n, result);
        return memo.get(n);
    }
    
    //  Recursive Solution;
    List<TreeNode> solve(int n){
        List<TreeNode> result = new ArrayList<>();
        
        //  Since FBT CAN NOT have "Even" No. of Nodes returing Empty List back to caller;
        if(n == 0 || n%2 == 0){
            return result;
        }
        //  Base case where N == 1; we create root node only with left and right child as NULL and add it to result list;
        if(n == 1){
            TreeNode node = new TreeNode(0);
            node.left = null;
            node.right = null;
            result.add(node);
        }
        
        for(int i=1; i<n; i+=2){
            //  Creating the different combinations of Left and Right sub-trees for all "Odd" values of "i";
            //  If I can create "i" Left Sub-Trees then it means I can only create "n-i-1" Right Sub-Trees because 1 will be for Main Root Node.
            List<TreeNode> leftTrees = solve(i);
            List<TreeNode> rightTrees = solve(n-i-1);
                   
            //  For Each unique combinations of leftTrees and rightTree Create a FBT and store it back in result list;
            for(int left=0; left<leftTrees.size(); left++){
                for(int right=0; right<rightTrees.size(); right++){
                    TreeNode node = new TreeNode(0);
                    node.left = leftTrees.get(left);
                    node.right = rightTrees.get(right);
                    result.add(node);
                }
            }
        }
        return result;
    }
}