class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
       
        for(int i=1;i<nums.length;i++)
            nums[i] = nums[i-1] + nums[i];
        
        int[] ans = new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int k = 0;
            while(k<nums.length){
                if(nums[k]>queries[i])
                    break;
                k++;
            }
            ans[i] = k;
        }
        return ans;
    }
}