class Solution {
    public int longestSubsequence(String s, int k) {
        int[][] dp = new int[s.length()+1][1000];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return helper(s,k,0,s.length()-1,dp);
    }

    int helper(String s,int remSum,int power,int index,int[][] dp){
        if(index < 0)
            return 0;
        
        if(dp[index][power]!=-1)
            return dp[index][power];

        int noTake = helper(s,remSum,power,index-1,dp);
        int take = 0;

        int rem = remSum - ((int)(Math.pow(2,power)) * (s.charAt(index) - '0'));
        if(rem >= 0){
            take = 1 + helper(s,rem,power+1,index-1,dp);
        }

        return dp[index][power] = Math.max(take,noTake);
    }
}