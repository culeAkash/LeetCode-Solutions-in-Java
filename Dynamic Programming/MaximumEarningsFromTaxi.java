class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {

        Arrays.sort(rides,(a,b)->a[0] - b[0]);

        long[] dp = new long[rides.length+1];
        Arrays.fill(dp,0);

        for(int curr = rides.length -1;curr>=0;curr--){
            long notake = dp[curr+1];
            int nextRide = nextRide(rides,curr,rides[curr][1]);
            int[] ride = rides[curr];
            long take = (ride[1] - ride[0] + ride[2]) + dp[nextRide];
            dp[curr] = Math.max(take,notake);
        }

        return dp[0];
    }


    public long helper(int[][] rides,int index,long[] dp){
        if(index >= rides.length)
            return 0;

        if(dp[index]!=-1)
            return dp[index];
    

        long notake = helper(rides,index+1,dp);


        int[] ride = rides[index];
        long take = (ride[1] - ride[0] + ride[2]) + helper(rides,nextRide(rides,index,ride[1]),dp);

        // System.out.println(take + " " + notake);
        return dp[index] =  Math.max(take,notake);

    }


    public int nextRide(int[][] rides,int start,int key){
        int end = rides.length - 1;
        int nextCurr = rides.length;

        while(start<=end){
            int mid = (end+start)/2;
            if(rides[mid][0] >= key){
                nextCurr = mid;
                end = mid-1;
            }
            else{
                start = mid + 1;
            }
        }

        return nextCurr;
    }
}