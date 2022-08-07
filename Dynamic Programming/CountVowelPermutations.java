class Solution {
    int mod = (int)1e9 + 7;
    long[][] dp;
    public int countVowelPermutation(int n) {
       
        
       char[] vowels = new char[]{'a','e','i','o','u'};
        
        dp = new long[6][n+1];
        
        for(int i=0;i<5;i++){
            dp[i][0] = 1;
        }
        
        
        long ans =  0;
        for(int i=0;i<5;i++){
            ans = (ans + helper(vowels[i],n-1))%mod;
        }
        
        return (int)ans;
    }
    
    public long helper(char vowel,int n){
        if(n==0)
            return 1;
        
        long ans = 0;
        
        if(vowel == 'a'){
            if(dp[0][n]!=0)return dp[0][n];
            ans = (ans + helper('e',n-1))%mod;
            dp[0][n] = ans;
        }
        else if(vowel == 'e'){
            if(dp[1][n]!=0) return dp[1][n];
            ans = (ans + helper('a',n-1) + helper('i',n-1))%mod;
            dp[1][n] = ans;
        }
        else if(vowel == 'i'){
            if(dp[2][n]!=0) return dp[2][n];
            ans = (ans + helper('a',n-1) + helper('e',n-1) + helper('o',n-1) + helper('u',n-1))%mod;
            dp[2][n] = ans;
        }
        else if(vowel == 'o'){
            if(dp[3][n]!=0) return dp[3][n];
            ans =  (ans + helper('i',n-1) + helper('u',n-1))%mod;
            dp[3][n] = ans;
        }
        else{
            if(dp[4][n]!=0) return dp[4][n];
            ans = (ans + helper('a',n-1))%mod;
            dp[4][n] = ans;
        }
        return ans;
    }
}