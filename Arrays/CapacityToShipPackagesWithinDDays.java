class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for(int weight : weights){
            left = Math.max(left,weight);
            right+= weight;
        }

        while(left < right){
            int mid = left + (right-left)/2;

            if(feasible(weights,days,mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    public boolean feasible(int[] weights,int maxDays,int maxLoad){
        int days = 1;

        int load = 0;
        for(int weight : weights){
            load += weight;

            if(load>maxLoad){
                days++;
                load = weight;
            }
        }

        return days<=maxDays;
    }
}