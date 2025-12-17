class Solution {
    public long maximumProfit(int[] prices, int k) {
        int N = prices.length;
        long[][][] dp = new long[N][k+1][3];

        for(long[][] d : dp){
            for(long[] p : d){
                Arrays.fill(p,-1);
            }
        }

        return helper(0,0,prices,k,dp,N);
    }

    private long helper(int index,int buy,int[] prices,int k,long[][][] dp,int N){
        if(index >= N){
            if(k>=0 && buy==0)return 0;
            return Integer.MIN_VALUE;
        }

        if(k==0)return 0;


        if(dp[index][k][buy]!=-1)
            return dp[index][k][buy];


        long profit = 0L;

        if(buy==1){
            // skip or sell
            profit = Math.max(helper(index+1,buy,prices,k,dp,N),prices[index] + helper(index+1,0,prices,k-1,dp,N));
        }else if(buy==2){
            //skip or buy
            profit = Math.max(helper(index+1,buy,prices,k,dp,N),-1*prices[index] + helper(index+1,0,prices,k-1,dp,N));
        }else{
            //skip buy or sell
            profit = Math.max(helper(index+1,buy,prices,k,dp,N),Math.max(prices[index] + helper(index+1,2,prices,k,dp,N),-1*prices[index] + helper(index+1,1,prices,k,dp,N)));
        }

        return dp[index][k][buy] = profit;

    }
}