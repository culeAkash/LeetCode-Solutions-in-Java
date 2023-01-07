class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int count = 0;

        for(int i=0;i<costs.length && coins>0;i++){
            if(coins<costs[i]){
                break;
            }
            coins -= costs[i];
            count++;
        }
        return count;
    }
}