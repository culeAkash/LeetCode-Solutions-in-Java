class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int N = prices.length;
        long[] orgPrefix = new long[N];
        long[] sellPrefix = new long[N];

        for(int index=0;index<N;index++){
            if(index==0){
                orgPrefix[index] = prices[index]*strategy[index];
                sellPrefix[index] = prices[index];
            }else{
                orgPrefix[index] = prices[index]*strategy[index] + orgPrefix[index-1];
                sellPrefix[index] = prices[index] + sellPrefix[index-1];
            }
        }

        long res = orgPrefix[N-1];
        long ans = Long.MIN_VALUE;

        for(int index=0;index<N-k+1;index++){
            int start = index;
            int end = index + k - 1;

            long orgPrev = start == 0 ? 0 : orgPrefix[start-1];
            long orgCurr = orgPrefix[end];

            // System.out.println(orgPrev + " " + orgCurr + " " + index);

            long temp =  res - (orgCurr - orgPrev);

            long sellPrev = sellPrefix[start + (k/2) - 1];
            long sellCurr = sellPrefix[start + k - 1];

            // System.out.println(sellPrev + " " + sellCurr + " " + index);

            temp += sellCurr - sellPrev;

            // System.out.println(temp+ " " + index);

            ans = Math.max(temp,Math.max(res,ans));
        }

        return ans;
    }
}