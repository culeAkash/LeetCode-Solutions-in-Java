class Solution {
    static int MOD = 1000000007;
    public int numberOfPaths(int[][] grid, int div) {
        int M = grid.length;
        int N = grid[0].length;
        int[][][] dp = new int[M+1][N+1][div];


        for(int row=M-1;row>=0;row--){
            for(int col=N-1;col>=0;col--){
                for(int k=div-1;k>=0;k--){
                    int newRem = (k+grid[row][col]) % div;

                    if(row==M-1 && col==N-1){
                        dp[row][col][k] = (newRem==0) ? 1 : 0;
                    }else{
                        int bottom = dp[row+1][col][newRem] % MOD;
                    
                    int right = dp[row][col+1][newRem] % MOD;
                    

                    dp[row][col][k] = (bottom + right) % MOD;
                    }  
                }
            }
        }
        // System.out.println(dp[M][N][0] + " " + M + " " + N);
        // for(int d[][] : dp){
        //     for(int[] p : d){
        //         for(int a : p){
        //             System.out.print(a + " ");
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }

        return dp[0][0][0];
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