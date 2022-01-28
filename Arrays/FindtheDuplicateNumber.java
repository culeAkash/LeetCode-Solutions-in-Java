class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        
        boolean[] isPresent= new boolean[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            isPresent[i]= false;
        }
        
        for(int i=0;i<nums.length;i++){
            if(isPresent[nums[i]-1]==true){
                return nums[i];
            }
            else{
                isPresent[nums[i]-1]=true;
            }
        }
        return -1;
    }
}