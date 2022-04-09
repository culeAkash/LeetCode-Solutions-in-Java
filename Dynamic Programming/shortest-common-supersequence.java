class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n= s1.length(),m= s2.length();
        int[][] dp= new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        //Finding SCS
        int i=n,j=m;
        String res = "";
        while(i>0 && j>0){
            //same character taking only once
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                res= s1.charAt(i-1)+res;
                i--;
                j--;
            }
            else{
                //moving up the s1 char will get lost
                if(dp[i-1][j]>dp[i][j-1]){
                    res= s1.charAt(i-1)+res;
                    i--;
                }
                //moving left s2 char will get lost
                else{
                    res = s2.charAt(j-1) +res;
                    j--;
                }
            }
        }
        while(i>0){
            res = s1.charAt(i-1) + res;
            i--;
        }
        while(j>0){
            res = s2.charAt(j-1) + res;
            j--;
        }
        return res;
    }
}