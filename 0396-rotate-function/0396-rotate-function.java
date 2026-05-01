class Solution {
    public int maxRotateFunction(int[] nums) {
        int N = nums.length;
        int prev = 0;
        int curr = 0;
        int sum = 0;

        for(int index=0;index<N;index++){
            prev += nums[index] * index;
            sum += nums[index];
        }

        int ans = prev;

        for(int index=1;index<N;index++){
            curr = prev + sum - (N * nums[N-index]);
            ans = Math.max(curr,ans);
            prev = curr;
        }

        return ans;
    }
}