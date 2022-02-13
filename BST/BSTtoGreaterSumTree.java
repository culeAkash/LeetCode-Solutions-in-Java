class Solution {
    int prev=0;
    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }
    
    public void helper(TreeNode root){
        if(root==null)
            return;
        
        helper(root.right);
        int sum= root.val+prev;
        root.val=sum;
        prev=sum;
        helper(root.left);
    }
}