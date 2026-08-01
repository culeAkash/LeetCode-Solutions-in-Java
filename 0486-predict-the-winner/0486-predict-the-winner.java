class Solution {
    public boolean predictTheWinner(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][N];
        for(int[] d : dp)Arrays.fill(d,-1);
        return helper(nums,0,N-1,dp) >= 0;
    }

    private int helper(int[] nums,int start,int end,int[][] dp){
        if(start==end)return nums[start];

        if(dp[start][end]!=-1)return dp[start][end];

        int left = nums[start] - helper(nums,start+1,end,dp);
        int right = nums[end] - helper(nums,start,end-1,dp);

        return Math.max(left,right);
    }
}