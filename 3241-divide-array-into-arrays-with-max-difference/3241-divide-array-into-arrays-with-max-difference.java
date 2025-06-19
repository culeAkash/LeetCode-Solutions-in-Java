class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums.length;
        int[][] res = new int[N/3][3];

        for(int i=0;i<N/3;i++){
            int start = i * 3;
            int end = start + 2;

            if(nums[end] - nums[start] > k){
                return new int[0][0];
            }else{
                res[i] = new int[]{nums[start],nums[start+1],nums[end]};
            }
        }
        return res;
    }
}