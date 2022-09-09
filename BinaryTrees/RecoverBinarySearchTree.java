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
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>(); 
        getInorderTraversal(root,nodes);
        
        List<Integer> vals = new ArrayList<>();
        for(TreeNode t : nodes)
            vals.add(t.val);
        
        Collections.sort(vals);
        
        for(int i=0;i<vals.size();i++)
            nodes.get(i).val = vals.get(i);
    }
    
    public void getInorderTraversal(TreeNode root,List<TreeNode> nodes){
        if(root==null)
            return;
        
        getInorderTraversal(root.left,nodes);
        nodes.add(root);
        getInorderTraversal(root.right,nodes);
            
    }
}