class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        int index = 0;

        while(index < nums.length && nums[index]!=1)index++;
        index++;
        while(index < nums.length){
            int num = nums[index++];
            if(num==0){count++;continue;}
            if(count < k)return false;
            count = 0;
        }

        return true;
    }
}