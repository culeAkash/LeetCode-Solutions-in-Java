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
    public boolean isCompleteTree(TreeNode root) {
        if(root.left==null && root.right==null)
            return true;
        
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        
        boolean flag = false;
        while(!pendingNodes.isEmpty()){
            TreeNode top = pendingNodes.poll();
            
            if(top.left!=null){
                if(flag)
                    return false;
                
                pendingNodes.offer(top.left);
            }
            else
                flag = true;
                
            if(top.right!=null){
                if(flag)
                    return false;
                
                pendingNodes.offer(top.right);
            }
            else
                flag = true;
        }
        return true;
    }
}