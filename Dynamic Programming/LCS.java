class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp= new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    private int helper(String s1,String s2,int ind1,int ind2,int[][] dp){
        if(ind1<0 || ind2<0)
            return 0;
        
        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];
        //matches condition
        if(s1.charAt(ind1)==s2.charAt(ind2))
            return dp[ind1][ind2] = 1+ helper(s1,s2,ind1-1,ind2-1,dp);
        
        //not match condition
        return dp[ind1][ind2] = Math.max(helper(s1,s2,ind1-1,ind2,dp),helper(s1,s2,ind1,ind2-1,dp));
    }
}