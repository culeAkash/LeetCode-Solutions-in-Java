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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        BalancedTreeReturn ans= helper(root);
        return ans.isBalanced;
    }
    
    private  BalancedTreeReturn helper(TreeNode root) {
        if(root==null){
            int height=0;
            boolean isBalanced=true;
            return new BalancedTreeReturn(height, isBalanced);
        }

        BalancedTreeReturn left= helper(root.left);
        BalancedTreeReturn right= helper(root.right);

        int height= 1+Math.max(left.height, right.height);
        boolean isBalanced=true;
        if(Math.abs(left.height-right.height)>1){
            isBalanced=false;
        }
        else{
            isBalanced= left.isBalanced && right.isBalanced;
        }
        return new BalancedTreeReturn(height, isBalanced);


    }
}

class BalancedTreeReturn{
    int height;
    boolean isBalanced;
    BalancedTreeReturn(int h,boolean ib){
        height=h;
        isBalanced=ib;
    }
}