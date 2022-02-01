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
    public TreeNode buildTree(int[] in, int[] post) {
        return helper(in,post,0,in.length-1,0,post.length-1);
    }
    
    private TreeNode helper(int[] in, int[] post, int startIn, int endIn, int startPost, int endPost) {
        if(startIn>endIn || startPost>endPost){
            return null;
        }

        int rootData= post[endPost];
        TreeNode root= new TreeNode(rootData);
        int i=0;
        while(in[i]!=rootData){
            i++;
        }
        int leftTreeLength= i-startIn;
        root.left= helper(in, post, startIn, startIn+leftTreeLength, startPost, startPost+leftTreeLength-1);
        root.right=helper(in, post, i+1, endIn, startPost+leftTreeLength, endPost-1);
        return root;
    }
}