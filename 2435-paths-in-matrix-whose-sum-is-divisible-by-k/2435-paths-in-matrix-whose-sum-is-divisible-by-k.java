class Solution {
    static int MOD = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int M = grid.length;
        int N = grid[0].length;
        int[][][] dp = new int[M][N][k];
        for(int[][] d : dp){
            for(int[] p : d){
                Arrays.fill(p,-1);
            }
        }
        return helper(0,0,0,grid,M,N,k,dp);
    }

    int helper(int row,int col,int rem,int[][] grid,int M,int N,int k,int[][][] dp){
        if(row<0 || col <0 || row>=M || col>=N)return 0;

        if(row==M-1 && col==N-1){
            if((rem + grid[row][col])%k==0)return 1;
            return 0;
        }

        if(dp[row][col][rem]!=-1)return dp[row][col][rem];

        int bottom = helper(row+1,col,(rem+grid[row][col])%k,grid,M,N,k,dp) % MOD;
        int right = helper(row,col+1,(rem+grid[row][col])%k,grid,M,N,k,dp) % MOD;

        return dp[row][col][rem] = (bottom + right) % MOD;
    }
}