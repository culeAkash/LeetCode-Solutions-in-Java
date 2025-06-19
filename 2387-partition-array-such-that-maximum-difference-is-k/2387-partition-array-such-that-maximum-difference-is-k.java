class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int mini = nums[0];
        int index = 1;
        int N = nums.length;
        int res = 1;
        while(index < N){
            if(nums[index] - mini > k){
                res++;
                mini = nums[index];
            }
            index++;
        }
        return res;
    }
}