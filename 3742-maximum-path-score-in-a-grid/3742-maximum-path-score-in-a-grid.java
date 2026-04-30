class Solution {
    private final int MIN = -100001;
    public int maxPathScore(int[][] grid, int k) {
        int N = grid.length;
        int M = grid[0].length;
        int[][][] dp = new int[N+1][M+1][k+1];
        Arrays.fill(dp[N][M],MIN);

        for(int row=N-1;row>=0;row--){
            for(int col=M-1;col>=0;col--){
                for(int c=0;c<=k;c++){
                    int cost = grid[row][col] == 0 ? 0 : 1; 
                    if(row==N-1 && col==M-1 && c - cost >= 0){
                        dp[row][col][c] = grid[row][col];
                        continue;
                    }
                    int right = MIN;
                    if(row+1<N && c-cost>=0){
                        right = grid[row][col] + dp[row+1][col][c-cost];
                    }
                    int bottom = MIN;
                    if(col+1 < M && c-cost>=0){
                        bottom = grid[row][col] + dp[row][col+1][c-cost];
                    }

                    dp[row][col][c] = Math.max(bottom,right);
                }
            }
        }

        int res = MIN;

        for(int c=0;c<=k;c++){
            res = Math.max(dp[0][0][c],res);
        }
    
        return  res < 0 ? -1 : res;
    }

    private int helper(int row,int col,int N,int M,int[][] grid,int k,int[][][] dp){
        if(k<0 || (row>=N || col>=M))return MIN;

        if(dp[row][col][k]!=-1)return dp[row][col][k];

        int cost = grid[row][col] == 0 ? 0 : 1;
        if(row==N-1 && col==M-1 && k>=cost)return grid[row][col];

        int right = grid[row][col] + helper(row,col+1,N,M,grid,k-cost,dp);
        int bottom = grid[row][col] + helper(row+1,col,N,M,grid,k-cost,dp);

        return dp[row][col][k] = Math.max(right,bottom);
    }
}