class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length+1];
        for(int i=0;i<days.length+1;i++){
            dp[i] = -1;
        }
        return helper(0,days,costs,dp);
    }
    
    public int helper(int index,int[] days,int[] costs,int[] dp){
        if(index>=days.length)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        
        int next1 = search(index,days[index],days);
        int next2 = search(index,days[index]+6,days);
        int next3 = search(index,days[index]+29,days);
        
        return dp[index] = Math.min(costs[0]+helper(next1,days,costs,dp),Math.min(costs[1]+helper(next2,days,costs,dp),costs[2]+helper(next3,days,costs,dp)));
    }
    
    private int search(int index,int value,int[] days){
        for(int i=index;i<days.length;i++)
        {
            if(days[i]>value)
                return i;
        }
        return days.length;
    }
}