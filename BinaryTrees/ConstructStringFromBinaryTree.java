class Solution {
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        helper(root);
        return sb.toString();
    }
    
    public void helper(TreeNode root){
        if(root==null)
            return;
        
        if(root.left==null && root.right==null)
        {
            sb.append(root.val);
            return;
        }
        
        sb.append(root.val);
        sb.append("(");
        helper(root.left);
        sb.append(")");
        
        if(root.right!=null){
            sb.append("(");
            helper(root.right);
            sb.append(")");
        }
        
    }
}