class Solution {
    public int minScoreTriangulation(int[] values) {
        int N = values.length;
        int[][] dp = new int[N][N];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        return solve(0,values.length-1,values,dp);
    }

    private int solve(int i,int j,int[] values,int[][] dp){
        if(i + 2 > j)return 0;
        if(i + 2 == j)return dp[i][j] = values[i] * values[i+1] * values[j];

        if(dp[i][j]!=-1)return dp[i][j];

        int res = Integer.MAX_VALUE;

        for(int k=i+1;k<j;k++){
            res = Math.min(res,values[i] * values[k] * values[j] + solve(i,k,values,dp) + solve(k,j,values,dp));
        }

        return dp[i][j] = res;
    }
}