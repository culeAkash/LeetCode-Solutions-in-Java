class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    
    public TreeNode helper(int[] arr,int start,int end){
        if(start>end)
        return null;

        int mid= (end-start)/2 + start;

        TreeNode root = new TreeNode(arr[mid]);
        root.left= helper(arr, start, mid-1);
        root.right= helper(arr, mid+1, end);

        return root;
    }
}