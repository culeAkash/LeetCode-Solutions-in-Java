class Solution {
    public int countSquares(int[][] matrix) {
        int[] dp = new int[matrix[0].length+1];
        int prev = 0;
        int ans = 0;
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]==1){
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(prev,Math.min(dp[j-1],dp[j]));
                    prev = temp;
                    ans += dp[j];
                }else{
                    dp[j] = 0;
                }
            }
        }
        return ans;
    }
}