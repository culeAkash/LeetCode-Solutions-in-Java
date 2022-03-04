class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length==0)
            return false;
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        return subsetSumToK(nums.length,sum/2,nums);
    }
    
    public  boolean subsetSumToK(int n, int k, int[] nums){
		if(nums.length==0)
            return false;
        
//         int n= nums.length;
        boolean[][] dp= new boolean[n][k+1];
        
        for(int i=0;i<n;i++)
            dp[i][0]=true;
        
        for(int i=0;i<=k;i++){
            if(i==nums[0])
                dp[0][i]=true;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                boolean notTake= dp[i-1][j];
                boolean take=false;
                if(nums[i]<=j)
                    take= dp[i-1][j-nums[i]];
                dp[i][j]= take || notTake;
            }
        }
        return dp[n-1][k];
	}
}