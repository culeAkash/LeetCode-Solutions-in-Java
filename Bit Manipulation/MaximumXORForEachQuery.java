class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xorVal = 0;
        for(int i:nums)
            xorVal = xorVal ^ i;
        
        int maxVal = (int)(Math.pow(2,maximumBit)) -1;
        int[] ans = new int[nums.length];
        int index=0;
        for(int i=nums.length-1;i>=0;i--){
            ans[index++] = maxVal-xorVal;
            xorVal = xorVal ^ nums[i];
        }
        return ans;
    }
}