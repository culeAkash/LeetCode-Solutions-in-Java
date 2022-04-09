class Solution {
    public boolean isMatch(String s1, String s2) {
        String temp= s1;
        s1=s2;
        s2=temp;
        int n = s1.length();
        int m = s2.length();
        
        boolean[][] dp= new boolean[n+1][m+1]; 
        //Base cases
        dp[0][0] = true;
        
        for(int j=1;j<=m;j++)
            dp[0][j] = false;
        
        for(int i=1;i<=n;i++){
            boolean flag = true;
            for(int k=0;k<i;k++){
                if(s1.charAt(k)!='*'){
                    flag =false;
                    break;
                }
            }
            dp[i][0] = flag;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(s1.charAt(i-1)=='*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] =  false;
            }
        }
        return dp[n][m];
    }
    
    public boolean helperRecursive(String s1,String s2,int i,int j){
        if(i<0 && j<0)
            return true;
        if(i<0 && j>=0)
            return false;
        if(j<0 && i>=0)
        {
            for(int k=0;k<i;k++){
                if(s1.charAt(k)!='*')
                    return false;
            }
            return true;
        }
        
        //Matching condition
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?')
            return helperRecursive( s1, s2, i-1, j-1);
        
        if(s1.charAt(i)=='*')
            return helperRecursive( s1, s2, i-1, j) || helperRecursive(s1,s2,i,j-1);
        return false;
    }
}