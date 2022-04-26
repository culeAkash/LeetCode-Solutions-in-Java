class Solution {
    public int stoneGameVII(int[] stones) {
        int sum = 0;
        int[][] dp = new int[stones.length][stones.length];
        for(int i=0;i<stones.length;i++){
            for(int j=0;j<stones.length;j++){
                dp[i][j] = -1;
            }
        }
        for(int i=0;i<stones.length;i++)
            sum+= stones[i];
        return helper(stones,0,stones.length-1,sum,dp);
    }
    
    private int helper(int[] stones,int first,int last,int sum,int[][] dp){
        if(first==last)
            return 0;
        if(dp[first][last] != -1)
            return dp[first][last];
        int firstRem = sum-stones[first] - helper(stones,first+1,last,sum-stones[first],dp);
        int lastRem = sum-stones[last] - helper(stones,first,last-1,sum-stones[last],dp);
        
        return dp[first][last] = Math.max(firstRem,lastRem);
    }
}