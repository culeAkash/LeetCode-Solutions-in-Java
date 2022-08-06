class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int i=1;i<dp.length;i++){
            int res = 0;
            for(int j = 0;j<nums.length;j++){
                if(i>=nums[j])
                res+= dp[i-nums[j]];
            }
            dp[i] = res;
        }
        return dp[target];
    }
}


/*
int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return helper(nums,target,dp);
    }
    
    public int helper(int[] nums,int target,int[] dp){
        if(target<0)
            return 0;
        
        if(target==0)
            return 1;
        
        if(dp[target]!=-1)
            return dp[target];
        
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res += helper(nums,target-nums[i],dp);
        }
        
        dp[target] = res;
        return res;

*/