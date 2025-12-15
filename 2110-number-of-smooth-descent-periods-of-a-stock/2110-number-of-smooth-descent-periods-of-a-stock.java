class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int count = 0;
        for(int index = 0;index < prices.length;index++){
            if(index == 0 || prices[index] != (prices[index-1]-1)){
                count = 1;
            }else{
                count++;
            }

            ans += count;
        }

        return ans;
    }
}