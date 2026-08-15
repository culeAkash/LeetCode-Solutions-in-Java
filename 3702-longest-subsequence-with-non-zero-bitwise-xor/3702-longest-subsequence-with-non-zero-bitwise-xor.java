class Solution {
    public int longestSubsequence(int[] nums) {
        int N = nums.length;

        int totalXor = 0;
        boolean allZeros = true;

        for(int num : nums){
            totalXor ^= num;

            if(num > 0)
                allZeros = false;
        }

        if(totalXor!=0)return N;

        return allZeros ? 0 : N -1 ;
    }
}