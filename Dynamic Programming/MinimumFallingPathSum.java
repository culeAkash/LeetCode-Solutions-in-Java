class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                dp[i][j] = -1;
            }
        }
        int min= Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            int val = helper(0,i,matrix,dp);
            min = Math.min(min,val);
        }
        return min;
    }
    public int helper(int row,int col,int[][] matrix,int[][] dp){
        if(row>=matrix.length)
            return 0;
        if(dp[row][col] != -1)
            return dp[row][col];
        int low = matrix[row][col] + helper(row+1,col,matrix,dp);
        int diagLeft = Integer.MAX_VALUE;
        int diagRight = Integer.MAX_VALUE;
        if(col>=1){
            diagLeft = matrix[row][col] + helper(row+1,col-1,matrix,dp);
        }
        
        if(col<matrix.length-1){
           diagRight =  matrix[row][col] + helper(row+1,col+1,matrix,dp);
        }
        return dp[row][col] = Math.min(low,Math.min(diagLeft,diagRight));
    }
}