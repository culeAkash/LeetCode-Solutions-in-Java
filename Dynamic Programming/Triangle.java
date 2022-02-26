class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n= triangle.size();
        int[][] dp= new int[n][n];
        
        for(int i=0; i<triangle.get(n-1).size();i++){
            dp[dp.length-1][i]= triangle.get(n-1).get(i);
        }
        
        for(int i=dp.length-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down= triangle.get(i).get(j)+dp[i+1][j];
                int diag= triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]= Math.min(diag,down);
            }
        }
        return dp[0][0];
        
        
    }
}