//Kadane's Algorithm

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
      int maxSum=nums[0];//atleast one element
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxSum){
                maxSum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }
}