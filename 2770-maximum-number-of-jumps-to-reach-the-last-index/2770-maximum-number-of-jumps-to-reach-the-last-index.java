class Solution {
    public int maximumJumps(int[] nums, int target) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[N-1] = 0;

        for(int i=N-2;i>=0;i--){
            int res = Integer.MIN_VALUE;

            for(int j=i+1;j<N;j++){
                if(((int)(Math.abs(nums[j]-nums[i])) <= target)){
                    res = Math.max(res,dp[j]+1);
                }
            }

            dp[i] = res;
        }

        int ans =  dp[0];
        return ans < 0 ? -1 : ans;
    }

    private int helper(int index,int[] nums,int target,int N,int[] dp){
        if(index >= N-1)return 0;

        if(dp[index]!=-1)return dp[index];

        int res = Integer.MIN_VALUE;

        for(int j=index+1;j<N;j++){
            if(((int)(Math.abs(nums[j]-nums[index])) <= target)){
                res = Math.max(res,helper(j,nums,target,N,dp)+1);
            }
        }

        return dp[index] = res;

    }
}