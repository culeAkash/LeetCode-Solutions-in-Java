class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long sum = 0;

        int fast = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(fast<nums.length && fast<k){
            sum += nums[fast];
            map.put(nums[fast],map.getOrDefault(nums[fast],0)+1);
            fast++;
        }
        int slow = 0;
        while(fast<nums.length){
            if(map.size()>=k)
                maxSum = Math.max(sum,maxSum);

            sum = sum + nums[fast] - nums[slow];
            map.put(nums[fast],map.getOrDefault(nums[fast],0)+1);

            if(map.get(nums[slow])==1){
                map.remove(nums[slow]);
            } 
            else{
                map.put(nums[slow],map.get(nums[slow])-1);
            }
            fast++;
            slow++;
        }
        if(map.size()>=k)
            maxSum = Math.max(maxSum,sum);
        return maxSum;
    }
}