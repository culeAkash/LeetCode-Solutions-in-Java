class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j = i+1,k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target)
                    return target;
                
                if(sum>target)
                    k--;
                else j++;
                
                if(Math.abs(sum-target)<Math.abs(ans-target))
                    ans = sum;
            }
        }
        return ans;
    }
}