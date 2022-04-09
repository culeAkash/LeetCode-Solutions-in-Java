class Solution {
    public int numDistinct(String s, String t) {
        int n= s.length();
        int m= t.length();
        int[][] dp= new int[n+1][m+1];//Index shifting
        
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
        
    }
    
    public int helperMemoized(String s1,String s2,int i,int j,int[][] dp){
        if(j<0)
            return 1;
        if(i<0)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        //Matching condition
        if(s1.charAt(i)==s2.charAt(j)){
            //We can take that occurrence or search for another occurrence
            return dp[i][j]=helperRecursive(s1,s2,i-1,j-1) + helperRecursive(s1,s2,i-1,j);
        }
        //Not mathing so search in the remaining s1 string
        return dp[i][j]=helperRecursive(s1,s2,i-1,j);
        
    }
    
    
    
    
    
    public int helperRecursive(String s1,String s2,int i,int j){
        if(j<0)
            return 1;
        if(i<0)
            return 0;
        
        
        //Matching condition
        if(s1.charAt(i)==s2.charAt(j)){
            //We can take that occurrence or search for another occurrence
            return helperRecursive(s1,s2,i-1,j-1) + helperRecursive(s1,s2,i-1,j);
        }
        //Not mathing so search in the remaining s1 string
        return helperRecursive(s1,s2,i-1,j);
    }
}