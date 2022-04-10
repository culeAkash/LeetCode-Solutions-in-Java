class Solution {
    public int maxProfit(int[] prices, int fee) {
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
                    int sellStockProfit = prices[index] + dp[index+1][1] - fee;
        int notSellStockProfit = dp[index+1][0];
         dp[index][canBuy] =  Math.max(sellStockProfit,notSellStockProfit);
                }
        
        
            }
        }
        return dp[0][1];
    }
}