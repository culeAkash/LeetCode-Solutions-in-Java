class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0,j = 0;
        int count = Integer.MAX_VALUE;
        int sum = 0;
        
        while(j<nums.length){
            sum += nums[j++];
            
            while(sum>=target){
                count = Math.min(count,(j-i));
                sum -= nums[i++];
            }
        }
        
        return count==Integer.MAX_VALUE?0:count;
        
    }
}