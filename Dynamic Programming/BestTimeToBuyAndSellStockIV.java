class Solution {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        int[][][] dp = new int[length+1][2][k+1];
        
        //Base cases
        //1. day=length
        for(int buy=0;buy<=1;buy++){
            for(int cap=0;cap<=k;cap++)
                dp[length][buy][cap] = 0;
        }
        //2. cap =0
        for(int day=0;day<length;day++){
            for(int buy=0;buy<=1;buy++)
                dp[day][buy][0] = 0;
        }
        
        for(int day = length-1;day>=0;day--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy==1){
                        dp[day][buy][cap] = Math.max((0-prices[day])+dp[day+1][0][cap],dp[day+1][1][cap]);
                    }
                    else{
                        dp[day][buy][cap] = Math.max((prices[day])+dp[day+1][1][cap-1],dp[day+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}