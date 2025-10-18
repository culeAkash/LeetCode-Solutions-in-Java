class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int prev = Integer.MIN_VALUE;
        for(int num : nums){
            int curr = Math.min(Math.max(num-k,prev+1),num+k);
            if(curr > prev){
                ans++;
                prev = curr;
            }
        }
        return ans;
    }
}