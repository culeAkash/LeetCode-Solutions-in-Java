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
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        List<Integer> paths = new ArrayList<>();
        countAllPaths(root,targetSum,paths);
        return count;
    }
    
    void countAllPaths(TreeNode root,int target,List<Integer> paths){
        if(root==null)
            return;
        
        paths.add(root.val);
        countAllPaths(root.left,target,paths);
        countAllPaths(root.right,target,paths);
        
        long sum = 0;
        for(int i=paths.size()-1;i>=0;i--){
            sum += paths.get(i);
            
            if(sum==target)
                count++;
        }
        paths.remove(paths.size()-1);
    }
}