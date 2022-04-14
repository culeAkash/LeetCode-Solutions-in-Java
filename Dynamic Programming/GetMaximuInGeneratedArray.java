class Solution {
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 0;
        for(int i=2;i<=n;i++){
            if(i%2==0){
                int j = i/2;
                dp[i] = dp[j];
            }
            else
            {
                int j = (i-1)/2;
                dp[i] = dp[j] + dp[j+1];
            }
            max= Math.max(dp[i],max);
        }
        return max;
    }
}