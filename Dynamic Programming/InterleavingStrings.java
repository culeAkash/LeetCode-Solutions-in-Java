class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        int[][] visited = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<visited.length;i++)
            Arrays.fill(visited[i],-1);
        return helper(s1,s2,s3,0,0,0,dp,visited);
    }
    
    public boolean helper(String s1,String s2,String s3,int i,int j,int k,boolean[][] dp,int[][] visited){
        if(i==s1.length() && j==s2.length() && k==s3.length())
            return true;
        if(i>s1.length() || j>s2.length())
            return false;
        if(k==s3.length()){
            if(i!=s1.length() || j!=s2.length())
                return false;
        }
        
        if(visited[i][j]!=-1)
            return dp[i][j];
        
        visited[i][j] =1;
        
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k) && j<s2.length() && s2.charAt(j)==s3.charAt(k))
            return dp[i][j] = helper(s1,s2,s3,i+1,j,k+1,dp,visited) || helper(s1,s2,s3,i,j+1,k+1,dp,visited);
        else if(i<s1.length() && s1.charAt(i)==s3.charAt(k))
            return dp[i][j] = helper(s1,s2,s3,i+1,j,k+1,dp,visited);
        else if(j<s2.length() && s2.charAt(j)==s3.charAt(k))
            return dp[i][j] = helper(s1,s2,s3,i,j+1,k+1,dp,visited);
        
        return dp[i][j] = false;
    }
}