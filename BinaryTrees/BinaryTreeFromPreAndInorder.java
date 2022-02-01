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
    public TreeNode buildTree(int[] pre, int[] in) {
        return helper(in,pre,0,in.length-1,0,pre.length-1);
    }
    
    private TreeNode helper(int[] in, int[] pre, int startIn, int endIn, int startPre, int endPre) {
        if(startIn>endIn){
            return null;
        }        
        if(startPre>endPre){
            return null;
        }

        int rootData= pre[startPre];
        TreeNode root= new TreeNode(rootData);
        int i=startIn;
        while(in[i]!=rootData){
            i++;
        }
        int leftTreeLength=i-startIn;
        root.left= helper(in, pre, startIn, i-1, startPre+1, startPre+leftTreeLength);
        root.right= helper(in, pre, i+1, endIn, startPre+leftTreeLength+1,endPre);
        return root;
    }
}