class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = 0;

        for(int i=0;i<nums.length;i++){
            maxDiff = Math.max(maxDiff,Math.max(nums[i],nums[(i+1)%nums.length]) - Math.min(nums[i],nums[(i+1)%nums.length]));
        }
        return maxDiff;
    }
}