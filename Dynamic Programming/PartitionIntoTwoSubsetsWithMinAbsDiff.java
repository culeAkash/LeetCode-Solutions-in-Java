public class Solution {
	public static int minSubsetSumDifference(int[] nums, int n) {
		// Write your code here.
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=(nums[i]);
        boolean[][] dp= new boolean[n][sum+1];
        subsetSumToK(n,sum,nums,dp);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++){
            if(dp[n-1][i]){
                int s1=i;
                int s2= sum - i;
                min= Math.min(min,Math.abs(s1-s2));
            }
        }
        return min;
	}
    
    public static void subsetSumToK(int n, int k, int[] nums,boolean[][] dp){
        
//         int n= nums.length;
        // boolean[][] dp= new boolean[n][k+1];
        
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
	}

}