class Solution {
    int MOD = 1000000007;
    public int numOfWays(int n) {
        int[][][][] dp = new int[n][4][4][4];
        for(int[][][] d : dp){
            for(int[][] p : d){
                for(int[] t : p){
                    Arrays.fill(t,-1);
                }
            }
        }
        return helper(0,0,0,0,dp,n) % MOD;
    }

    private int helper(int row,int prev1,int prev2,int prev3,int[][][][] dp,int N){
        if(row>=N)return 1;

        if(dp[row][prev1][prev2][prev3]!=-1)return dp[row][prev1][prev2][prev3];

        int ans = 0;
        for(int col1=1;col1<=3;col1++){
            if(col1==prev1)continue;
            for(int col2=1;col2<=3;col2++){
                if(col2==prev2 || col2==col1)continue;
                for(int col3=1;col3<=3;col3++){
                    if(col3==prev3||col3==col2)continue;

                    ans = (ans + (helper(row+1,col1,col2,col3,dp,N)%MOD)) % MOD;
                }
            }
        }

        return dp[row][prev1][prev2][prev3] = ans;
    }

}