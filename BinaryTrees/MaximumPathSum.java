class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max= new int[1];
        max[0]=Integer.MIN_VALUE;
        helper(root,max);
        return max[0];
    }
    
    public int helper(TreeNode root,int[] max){
        if(root==null)
            return 0;
        
        int leftAns= Math.max(0,helper(root.left,max));
        int rightAns= Math.max(0,helper(root.right,max));
        
        max[0]= Math.max(max[0],root.val+leftAns+rightAns);//Taking path from each node into consideration
        return root.val+Math.max(leftAns,rightAns);//only one path can be taken so that no node appears twice in a path
    }
}