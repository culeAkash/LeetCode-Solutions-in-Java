class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int a : piles){
            max =  Math.max(a,max);
        }

        int low = 1;
        int high = max;

        while(low<=high){
            int mid = low + (high-low)/2;

            int temp = find(mid,piles);

            if(temp<=h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    public int find(int mid,int[] piles){
        double ans = 0;

        for(int p : piles){
            double temp = Math.ceil(p*(1.0)/mid);
            ans += temp;
        }

        return (int)ans;
    }
}