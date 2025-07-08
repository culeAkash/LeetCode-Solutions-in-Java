class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,((int a[],int b[])->a[0] - b[0]));

        int[][] dp = new int[events.length][k+1];

        for(int[] d : dp)
        Arrays.fill(d,-1);
        
        int ans = helper(events,0,k,dp);

        return ans;
    }


    public int helper(int[][] events,int index,int k,int[][] dp){
        if(index >= events.length || k==0){
            return 0;
        }

        if(dp[index][k] != -1)
            return dp[index][k];

        //take
        int nextIndex = findNextGreater(events,events[index][1]);
        
        int   take = events[index][2] + helper(events,nextIndex,k-1,dp);
        int notake = helper(events,index+1,k,dp);

        // System.out.println(take + " " + notake);

        return dp[index][k] = Math.max(take,notake);
    }


    int findNextGreater(int[][] events,int target){
        int start = 0, end = events.length - 1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(events[mid][0] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}