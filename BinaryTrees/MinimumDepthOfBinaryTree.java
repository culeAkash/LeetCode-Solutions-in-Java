class Solution {
    public int minDepth(TreeNode root) {
        int ans = helper(root);
        // System.out.println(ans);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    } 
    public int helper(TreeNode root){
        if(root==null)
        return Integer.MAX_VALUE;

        if(root.left== null && root.right==null)
            return 1;

        // int depth = 1;

        int left = helper(root.left);
        int right = helper(root.right);

        int depth = 1 + Math.min(left,right);

        return depth;
    }
}