class Solution {
    public int maxProfit(int[] prices) {
        int minCost=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minCost){
                minCost=prices[i];
            }
            int currProfit=prices[i]-minCost;
            maxProfit= Math.maxProfit(max,currProfit);
        }
        return maxProfit;
    }
}