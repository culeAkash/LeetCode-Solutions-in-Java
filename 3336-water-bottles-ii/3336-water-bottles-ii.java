class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullBottles = numBottles;
        int emptyBottles = 0;
        int res = 0;

        while(fullBottles!=0 || emptyBottles >= numExchange){
            if(emptyBottles >= numExchange){
                fullBottles++;
                emptyBottles -= numExchange++;
            }else{
                res += fullBottles;
                emptyBottles += fullBottles;
                fullBottles = 0;
            }
        }
        return res;
    }
}