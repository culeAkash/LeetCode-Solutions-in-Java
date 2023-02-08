class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
       
            Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }

    public int helper(int[] nums,int index,int[] dp){
        if(index >= nums.length)
            return Integer.MAX_VALUE;

        if(index==nums.length-1){
            return 0;
        }

        if(dp[index]!=-1)
            return dp[index];

        long min = Integer.MAX_VALUE;
        for(int idx = index+1 ;idx <= (index+nums[index]) && idx < nums.length;idx++){
            long temp = 1;
            temp += helper(nums,idx,dp);
            min = Math.min(min,temp);
        }
        return dp[index] = (int)min;
    }
}