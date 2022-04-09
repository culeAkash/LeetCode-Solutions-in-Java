class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        int ans= helper(coins,amount,coins.length-1,dp);
        return (ans>=(int)1e9)?-1:ans;
    }
    
    public int helper(int[] coins,int target,int i,int[][] dp){
        if(i==0){
            if(target%coins[i]==0)
                return target/coins[i];
            return (int)1e9;
        }
        if(dp[i][target]!=-1)
            return dp[i][target];
        
        int take= Integer.MAX_VALUE;
        if(coins[i]<=target)
            take= 1+ helper(coins,target-coins[i],i,dp);
        int notTake= helper(coins,target,i-1,dp);
        dp[i][target]= Math.min(take,notTake);
        return dp[i][target];
    }
}