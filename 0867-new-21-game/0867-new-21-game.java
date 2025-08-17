class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0 || n >= k + maxPts) return 1.0;

        double dp[] = new double[n+1];
        dp[0] = 1.0;
        double ans = 0.0;
        double runningSum = 1.0;

        for(int i=1;i<=n;i++){
            dp[i] = runningSum * (1.0 / maxPts);

            if(i < k)
                runningSum += dp[i];
            else
                ans += dp[i];
            
            if(i >= maxPts){
                runningSum -= dp[i - maxPts];
            }
        }

        return ans;
    }
}