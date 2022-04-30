public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                dp[i][j] = -1;
            }
        }                                          
        return helper(nums,0,nums.length-1,dp)>=0?true:false;
    }
    
    public int helper(int[] nums,int i,int j,int[][] dp){
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int takeLeft = nums[i] - helper(nums,i+1,j,dp);
        int takeRight = nums[j] - helper(nums,i,j-1,dp);
        
        return dp[i][j] = Math.max(takeLeft,takeRight);
    }
}