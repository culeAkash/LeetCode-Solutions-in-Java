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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
       ans = 0;
        helper(root);
        return ans;
    }

    int helper(TreeNode root){
        if(root==null)
            return 0;

        int leftAns = helper(root.left);
        int rightAns = helper(root.right);

        int left =0,right = 0;

        //check if left child is same as root node
        if(root.left!=null && root.left.val==root.val){
            left = leftAns + 1;
        }

        //check if right child is same as root node
        if(root.right!=null &&root.right.val==root.val){
            right = rightAns + 1;
        }

        ans = Math.max(ans,left+right);
        return Math.max(left,right);
    }
}