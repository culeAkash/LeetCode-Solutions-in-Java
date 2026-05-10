class Solution {
    public int maximumJumps(int[] nums, int target) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp,-1);
        int ans =  helper(0,nums,target,N,dp);
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