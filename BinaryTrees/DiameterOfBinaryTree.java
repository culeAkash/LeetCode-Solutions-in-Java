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
    public int diameterOfBinaryTree(TreeNode root) {
        DiameterReturn ans= helper(root);
        return ans.diameter;
    }
    
    
    private DiameterReturn helper(TreeNode root) {
        if(root==null){
            return new DiameterReturn(0, 0);
        }

        DiameterReturn leftAns= helper(root.left);
        DiameterReturn rightAns= helper(root.right);

        int dist= leftAns.height+rightAns.height;
        int diameter= Math.max(leftAns.diameter, Math.max(rightAns.diameter, dist));
        int height= 1+Math.max(leftAns.height, rightAns.height);
        return new DiameterReturn(height, diameter);
    }
}


class DiameterReturn{
    int height;
    int diameter;
    DiameterReturn(int h,int d){
        height=h;
        diameter=d;
    }
}