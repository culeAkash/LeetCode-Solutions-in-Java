class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0, rt = 0;
        long curr = 0;
        while (rt < n) {
            int v = map.getOrDefault(nums[rt], 0);
            curr += v;
            map.put(nums[rt], v+1);
            while (curr >= k) {
                // adding everytime as this subarray starts at different postion
                // takes into account all the ending postion for start = lt
                ans += n-rt;
                // nums[lt] always there, as added by when rt was there.
                v = map.get(nums[lt]);
                curr -= v-1;
                map.put(nums[lt], v-1);
                lt++;
            }
            rt++;
        }
        return ans;
        
    }
}