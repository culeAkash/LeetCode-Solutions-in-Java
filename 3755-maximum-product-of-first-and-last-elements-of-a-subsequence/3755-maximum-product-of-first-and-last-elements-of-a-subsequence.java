class Solution {
    public long maximumProduct(int[] nums, int m) {
        long res = Long.MIN_VALUE;
        if(m==1){
            for(int num : nums){
                res = Math.max(res,1L*num*num);
            }
            return res;
        }
        long maxi = Long.MIN_VALUE;
        long mini = Long.MAX_VALUE;

        

        for(int j = m-1;j<nums.length;j++){
            int i = j - m + 1;

            mini = Math.min(mini,nums[i]);
            maxi = Math.max(maxi,nums[i]);

            long prod = Math.max(1L*mini*nums[j],1L*maxi*nums[j]);
            res = Math.max(res,prod);
        }

        return res;
    }
}