class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,((int a[],int b[])->a[0] - b[0]));

        // int presentStart = 0;
        int presentEnd = 0;

        int[][] dp = new int[events.length][k+1];

        for(int[] d : dp)
        Arrays.fill(d,-1);
        
        int ans = helper(events,presentEnd,0,k,dp);

        return ans;
    }


    public int helper(int[][] events,int end,int index,int k,int[][] dp){
        if(index >= events.length || k==0){
            return 0;
        }

        if(events[index][0] <=end) return helper(events,end,index+1,k,dp);

        if(dp[index][k] != -1)
            return dp[index][k];

        //take
       
         int   take = events[index][2] + helper(events,events[index][1],index+1,k-1,dp);

        int notake = helper(events,end,index+1,k,dp);

        // System.out.println(take + " " + notake);

        return dp[index][k] = Math.max(take,notake);
    }
}