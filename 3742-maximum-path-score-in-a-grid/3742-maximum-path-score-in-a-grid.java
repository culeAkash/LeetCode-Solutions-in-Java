class Solution {
    private final int MIN = -100001;
    public int maxPathScore(int[][] grid, int k) {
        int N = grid.length;
        int M = grid[0].length;
        int[][][] dp = new int[N][M][k+1];
        for(int [][] d : dp){
            for(int[] p : d)
                Arrays.fill(p,-1);
        }
        int res = helper(0,0,N,M,grid,k,dp);
        return  res < 0 ? -1 : res;
    }

    private int helper(int row,int col,int N,int M,int[][] grid,int k,int[][][] dp){
        if(k<0 || (row>=N || col>=M))return MIN;

        if(dp[row][col][k]!=-1)return dp[row][col][k];

        int cost = grid[row][col] == 0 ? 0 : 1;
        int K = k;
        k = k - cost;
        if(row==N-1 && col==M-1 && k>=0)return grid[row][col];

        

        int right = grid[row][col] + helper(row,col+1,N,M,grid,k,dp);
        int bottom = grid[row][col] + helper(row+1,col,N,M,grid,k,dp);

        return dp[row][col][K] = Math.max(right,bottom);
    }
}