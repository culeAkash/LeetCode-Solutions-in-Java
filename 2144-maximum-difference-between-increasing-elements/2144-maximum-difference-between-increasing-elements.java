class Solution {
    public int maximumDifference(int[] nums) {
        int mini = Integer.MAX_VALUE;

        int maxDiff = 0;

        for(int num : nums){
            mini = Math.min(num,mini);

            maxDiff = Math.max(maxDiff,(num - mini));
        }

        return maxDiff == 0 ? -1 : maxDiff;
    }
}