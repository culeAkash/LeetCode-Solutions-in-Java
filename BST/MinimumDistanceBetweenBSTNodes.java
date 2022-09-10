class Solution {
    int prev = -1;
    int minDiff;
    public int minDiffInBST(TreeNode root) {
        prev = -1;
         minDiff = Integer.MAX_VALUE;
        helper(root);
        return minDiff;
    }
    
    void helper(TreeNode root){
        if(root==null)
            return;
        System.out.println(prev + " " +root.val);
        helper(root.left);
        if(prev==-1){
            prev = root.val;
            }
        else{
            minDiff = Math.min(root.val-prev,minDiff);
            prev =  root.val;
        }
        System.out.println(prev + " " +root.val);
        helper(root.right);
    }
}