class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] prefix = new long[k];
        long res = Long.MIN_VALUE;
        int index = 0;
        long sum = 0L;
        Arrays.fill(prefix,Long.MAX_VALUE/2);
        prefix[0]=0L;
        int N = nums.length;
        while(index < N){
            sum += nums[index];
            int l = (index + 1)%k;

            res = Math.max(res,sum-prefix[l]);
            prefix[l] = Math.min(prefix[l],sum);
            index++;
        }

        return res;

    }
}