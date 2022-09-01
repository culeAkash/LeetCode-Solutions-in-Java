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
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        
        
        return helper(root,Integer.MIN_VALUE);
    }
    
    public int helper(TreeNode root,int max){
        if(root==null)
            return 0;
        
        int count = 0;
        
        if(root.val>=max){
            count = 1;
            count += helper(root.left,root.val);
            count += helper(root.right,root.val);
        }
        else{
            count += helper(root.left,max);
            count += helper(root.right,max);
        }
        return count;
    }
}