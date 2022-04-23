class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1,word2,word1.length(),word2.length());
        return word1.length()+word2.length()-2*lcs;
    }
    
    private int lcs(String x, String y, int n, int m) {
		if(n==0 || m==0) {
			return 0;
		}
		
		int[][] dp= new int[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}
				else if(x.charAt(i-1)==y.charAt(j-1)) {
					dp[i][j]= 1+ dp[i-1][j-1];
				}
				else {
					dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][m];
	}
}