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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        TreeNode root = helper(nums,start,end);
        return root;
    }

    TreeNode helper(int[] nums,int start,int end){
        if(start>end)
            return null;

        int highest[] = findHighest(nums,start,end);

        TreeNode root = new TreeNode(highest[1]);

        root.left = helper(nums,start,highest[0]-1);
        root.right = helper(nums,highest[0]+1,end);
        return root;

    }

    int[] findHighest(int[] nums,int start,int end){
        int high[] = new int[2];
        high[0] = start;
        high[1] = nums[start];
        for(int i=start;i<=end;i++){
            if(nums[i]>high[1]){
                high[1] = nums[i];
                high[0] = i;
            }
        }
        return high;
        
    }
}