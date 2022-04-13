        int[] dp = new int[numberOfHouses+2];
        
        for(int i=2;i<dp.length;i++){
            //rob from ith house
        int rob = nums[i-2] + dp[i-2];
        
        //not rob
        int notRob = dp[i-1];
         dp[i] = Math.max(rob,notRob);
        }
        return dp[dp.length-1];
    }
    
    
    
    
    public int rob1(int[] nums) {
        int numberOfHouses = nums.length;
        int[] dp = new int[numberOfHouses];
        Arrays.fill(dp,-1);
        return helper(numberOfHouses-1,numberOfHouses,nums,dp);
    }
    public int helper(int i,int n,int[] nums,int[] dp){
        if(i<0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        
        //rob from ith house
        int rob = nums[i] + helper(i-2,n,nums,dp);
        
        //not rob
        int notRob = helper(i-1,n,nums,dp);
        return dp[i] = Math.max(rob,notRob);
    }