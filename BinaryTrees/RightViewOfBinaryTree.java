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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        helper(root,0,ans);
        return ans;
    }
    
    public void helper(TreeNode root,int level,List<Integer> ans){
        //if root is null
        if(root==null){
            return;
        }
        
        //If the ans is of same length of the level insert the node
        if(ans.size()==level){
            ans.add(root.val);
        }
        
        //As we are finding right view we move to right then left
        helper(root.right,level+1,ans);
        helper(root.left,level+1,ans);
    }
}