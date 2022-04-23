class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for(int i=0;i<piles.length;i++){
            for(int j=0;j<piles.length;j++)
                dp[i][j]=-1;
        }
        int alice = helper(0,piles.length-1,piles,true,dp);
        int sum=0;
        int i=0;
        while(i<piles.length)
            sum+=piles[i++];
        return alice>sum/2?true:false;
    }
    
    public int helper(int i,int j,int[] piles,boolean chance,int[][] dp){
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(chance){
            int takeFirst = piles[i] + helper(i+1,j,piles,false,dp);
            int takeLast = piles[j] + helper(i,j-1,piles,false,dp);
            return dp[i][j] = Math.max(takeFirst,takeLast);
        }
        return dp[i][j] = Math.max(helper(i+1,j,piles,true,dp),helper(i,j-1,piles,true,dp));
    }
}