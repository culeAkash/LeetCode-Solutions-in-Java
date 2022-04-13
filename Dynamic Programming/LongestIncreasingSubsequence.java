//Memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length+1];
        for(int i=0;i<length;i++){
            for(int j=0;j<=length;j++)
                dp[i][j] = -1;
        }
        return helper(nums,0,-1,dp);
        
    }
    
    public int helper(int[] nums,int index,int maxIndex,int[][] dp){
        if(index==nums.length)
            return 0;
        if(dp[index][maxIndex+1]!=-1)
            return dp[index][maxIndex+1];
        
        //take
        if(maxIndex==-1 || nums[index]>nums[maxIndex]){
            return dp[index][maxIndex+1] = Math.max((1+helper(nums,index+1,index,dp)),helper(nums,index+1,maxIndex,dp));
        }
        return dp[index][maxIndex+1] = helper(nums,index+1,maxIndex,dp);
    }
}