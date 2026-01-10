class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int val1 = 0;
        int val2 = 0;
        int N = s1.length();
        int M = s2.length();

        int[][] dp = new int[N][M];

        for(int[] d : dp)
            Arrays.fill(d,-1);

        for(int i=0;i<N;i++)
            val1 += s1.charAt(i);

        for(int i=0;i<M;i++)
            val2 += s2.charAt(i);
        // System.out.println(helper(s1,s2,0,0,N,M).val);
        return val1 + val2 - 2 * (helper(s1,s2,0,0,N,M,dp));
    }

    private int helper(String s1,String s2,int i1,int i2,int N,int M,int[][] dp){
        if(i1>=N || i2>=M)return 0;

        if(dp[i1][i2]!=-1)return dp[i1][i2];

        if(s1.charAt(i1)==s2.charAt(i2)){
            int temp = helper(s1,s2,i1+1,i2+1,N,M,dp);
            return dp[i1][i2] = temp + s1.charAt(i1);
        }else{
            int skip1 = helper(s1,s2,i1,i2+1,N,M,dp);
            int skip2 = helper(s1,s2,i1+1,i2,N,M,dp);

            if(skip1 > skip2){
                return dp[i1][i2] = skip1;
            }else{
                return dp[i1][i2] = skip2;
            }
        }
    }
}