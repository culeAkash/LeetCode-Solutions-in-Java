class Solution {
    public int maxRotateFunction(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int sum = 0;

        for(int index=0;index<N;index++){
            dp[0] += nums[index] * index;
            sum += nums[index];
        }

        int ans = dp[0];

        for(int index=1;index<N;index++){
            dp[index] = dp[index-1] + sum - (N * nums[N-index]);
            ans = Math.max(dp[index],ans);
        }

        return ans;
    }
}