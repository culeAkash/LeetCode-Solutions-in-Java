class Solution {
    public int wiggleMaxLength(int[] nums) {
       if(nums.length<=1)
           return 1;
        int prevSign = nums[1]-nums[0];
        int length = prevSign!=0?2:1;
        
        for(int i=2;i<nums.length;i++){
            if((nums[i]-nums[i-1]>0 && prevSign<=0) || (nums[i]-nums[i-1]<0 && prevSign>=0)){
                length++;
                prevSign = nums[i]-nums[i-1];
            }
        }
        return length;
        
    }
}