class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = matrix.clone();
        int ans = 0;

        

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 || j==0){
                    ans += dp[i][j];
                    continue;
                }
                if(dp[i][j]!=0){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}