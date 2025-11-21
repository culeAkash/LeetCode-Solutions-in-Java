class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1,right = 1;
        int N = nums.length;
        int[] ans = new int[N];
        for(int index=N-1;index>=0;index--){
            ans[index] = right;
            right *= nums[index];
        }

        for(int index=0;index<N;index++){
            ans[index] *= left;
            left *= nums[index];
        }

        return ans;
    }
}