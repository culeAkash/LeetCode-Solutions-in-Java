class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[maxMove+1][m][n];
        
        for(long[][] a: dp){
            for(long[] b: a){
                Arrays.fill(b,-1);
            }
            }
        return (int)helper(dp,m,n,maxMove,startRow,startColumn);
    }
    
    public long helper(long[][][] dp,int m,int n,int max,int i,int j){
        if(i<0 || i>=m || j<0 || j>=n)
            return 1;
        if(max<=0)
            return 0;
        
        if(dp[max][i][j] != -1)
            return dp[max][i][j];
        
        return dp[max][i][j] = (helper(dp,m,n,max-1,i+1,j) + helper(dp,m,n,max-1,i,j+1) + helper(dp,m,n,max-1,i-1,j) + helper(dp,m,n,max-1,i,j-1))%mod; 
    }
}