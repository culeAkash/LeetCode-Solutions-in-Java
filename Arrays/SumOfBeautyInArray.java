class Solution {
    public int sumOfBeauties(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];


        for(int i=0;i<nums.length;i++){
            if(i==0){
                left[i] = 0;
            }
            else{
                left[i] = Math.max(nums[i-1],left[i-1]);
            }
        }

        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                right[i] = Integer.MAX_VALUE;
            }
            else{
                right[i] = Math.min(nums[i+1],right[i+1]);
            }
        }

        int res = 0;

        for(int i=1;i<nums.length-1;i++){
            System.out.println(left[i] + " " + right[i]);
            if(left[i] < nums[i] && right[i] > nums[i]){
                
                res += 2;
            }
                
            else if(nums[i-1] < nums[i] && nums[i+1] > nums[i])
                res += 1;
        }

        return res;

    }
}