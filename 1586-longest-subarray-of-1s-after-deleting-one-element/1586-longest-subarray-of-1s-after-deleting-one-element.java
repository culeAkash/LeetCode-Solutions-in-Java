class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0;
        int zeros = 0;
        int res = 0;

        while(end < nums.length){
            if(nums[end] == 0){
                zeros++;
            }

            while(zeros > 1){
                if(nums[start]==0)
                    zeros--;
                start++;
            }

            res = Math.max(res,end-start+1-zeros);
            end++;
        }

        return zeros == 0 ? res - 1 : res;
    }
}