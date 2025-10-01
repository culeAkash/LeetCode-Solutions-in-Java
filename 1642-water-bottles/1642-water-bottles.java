class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int filledBottles = numBottles;
        int emptyBottles = 0;
        int ans = 0;
        while(filledBottles!=0){
            ans += filledBottles; 
            int temp = emptyBottles;
            emptyBottles = (filledBottles + emptyBottles) % numExchange;
            filledBottles = (filledBottles + temp) / numExchange;
        }
        return ans;
    }
}