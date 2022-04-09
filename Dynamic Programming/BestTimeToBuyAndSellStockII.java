class Solution {
    public int maxProfit(int[] prices){
        int length = prices.length;
        int[][] dp = new int[length+1][2];
        
        dp[length][0] = dp[length][1] = 0;
        
        for(int index=length-1;index>=0;index--){
            for(int canBuy=0;canBuy<=1;canBuy++){
                if(canBuy==1){
            int buyStockProfit = (0-prices[index]) + dp[index+1][0];
            int notBuyStockProfit = dp[index+1][1];
             dp[index][canBuy] = Math.max(buyStockProfit,notBuyStockProfit);
        }
                else{
                    int sellStockProfit = prices[index] + dp[index+1][1];
        int notSellStockProfit = dp[index+1][0];
         dp[index][canBuy] =  Math.max(sellStockProfit,notSellStockProfit);
                }
        
        
            }
        }
        return dp[0][1];
    }
    
    
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        int[][] dp= new int[length][2];
        for(int i=0;i<length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return maxProfitHelper(0,length,prices,1,dp);
    }
    
    private int maxProfitHelper(int index,int numOfDays,int[] prices,int canBuy,int[][] dp){
        if(index==numOfDays)
            return 0;
        if(dp[index][canBuy]!=-1)
            return dp[index][canBuy];
        if(canBuy==1){
            int buyStockProfit = (0-prices[index]) + maxProfitHelper(index+1,numOfDays,prices,0,dp);
            int notBuyStockProfit = maxProfitHelper(index+1,numOfDays,prices,1,dp);
            return dp[index][canBuy] = Math.max(buyStockProfit,notBuyStockProfit);
        }
        
        int sellStockProfit = prices[index] + maxProfitHelper(index+1,numOfDays,prices,1,dp);
        int notSellStockProfit = maxProfitHelper(index+1,numOfDays,prices,0,dp);
        return dp[index][canBuy] =  Math.max(sellStockProfit,notSellStockProfit);
        
    }
}