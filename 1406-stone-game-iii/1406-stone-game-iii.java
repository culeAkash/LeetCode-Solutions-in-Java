class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int N = stoneValue.length;
        int[] dp = new int[N];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int ans = helper(stoneValue,0,N,dp);

        return ans > 0 ? "Alice" : (ans==0 ? "Tie" : "Bob");
    }

    private int helper(int[] stoneValue,int index,int N,int[] dp){
        if(index>=N)return 0;

        if(dp[index]!= Integer.MIN_VALUE)return dp[index];

        int sum = 0;
        int res = Integer.MIN_VALUE;
        for(int k=0;k<3 && index + k < N ;k++){
            sum += stoneValue[index+k];
            res = Math.max(res,sum - helper(stoneValue,index+k+1,N,dp));
        }

        return dp[index] = res;
    }
}