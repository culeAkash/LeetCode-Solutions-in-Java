class Solution {
    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        int[] prefixTime = new int[n];
        prefixTime[0] = time[0];
        for(int i=1;i<n;i++){
            prefixTime[i] = prefixTime[i-1] + time[i];
        }
        int[][][] dp = new int[n][n+1][k+1];
        for(int[][] d : dp){
            for(int[] p : d){
                Arrays.fill(p,-1);
            }
        }
        return helper(0,0,k,position,time,dp,n,prefixTime);
    }

    int helper(int i,int last,int k,int[] position,int[] time,int[][][] dp,int n,int[] prefixTime){
        if(i==n-1){
            if(k==0)return 0;
            return 10000000;
        }

        if(dp[i][last][k]!=-1)
            return dp[i][last][k];

        int rate = prefixTime[i] - (last > 0 ? prefixTime[last-1] : 0);
        int ans = 10000000;

        int till = Math.min(n-1,i+k+1);

        for(int j=i+1;j<=till;j++){
            int dist = position[j] - position[i];
            int temp = dist * rate + helper(j,i+1,k-(j-i-1),position,time,dp,n,prefixTime);
            ans = Math.min(temp,ans);
        }
        return dp[i][last][k] = ans;
    }
}