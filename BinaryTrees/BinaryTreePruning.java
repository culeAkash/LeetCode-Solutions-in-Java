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
    public TreeNode pruneTree(TreeNode root) {
        
        if(!helper(root))
            return null;
        return root;
    }
    
    public boolean helper(TreeNode root){
        if(root==null)
            return false;
        
        boolean leftAns = helper(root.left);
        boolean rightAns = helper(root.right);
        
        if(!leftAns)
            root.left = null;
        
        if(!rightAns)
            root.right = null;
        
        if(root.val==1)
            return true;
        
        return leftAns || rightAns;
            
    }
}