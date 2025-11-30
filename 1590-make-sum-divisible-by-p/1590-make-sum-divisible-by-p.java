class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;

        for(int num : nums)
            sum = (sum + num) % p;

        int target = sum % p;

        if(target == 0)return 0;

        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,-1);

        int currSum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            currSum = (currSum + nums[i]) % p;

            int needed = (currSum - target + p) % p;

            if(mpp.containsKey(needed))
                minLen = Math.min(minLen,i - mpp.get(needed));

            mpp.put(currSum,i);
        }

        return minLen >= nums.length ? -1 : minLen;
    }
}