class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length-3;i++){
            long target1 = target - (long)nums[i];
            
            for(int j=i+1;j<nums.length-2;j++){
                long target2 = target1 - (long)nums[j];
                
                int low = j+1,high = nums.length-1;
                
                while(low<high){
                    
                    if((long)nums[low]+(long)nums[high]==target2){
                        List<Integer> sm = new ArrayList<>();
                        sm.add(nums[i]);
                        sm.add(nums[j]);
                        sm.add(nums[low]);
                        sm.add(nums[high]);
                        ans.add(sm);
                        
                        //Ignoring identical lows and highs
                        while(low<high && nums[low]==nums[low+1])low++;
                        while(low<high && nums[high]==nums[high-1])high--;
                        
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]<target2){
                        low++;
                    }
                    else
                        high--;
                }
                
                while(j<nums.length-2 && nums[j]==nums[j+1])j++;//ignore duplicates of j
            }
            while(i<nums.length-3 && nums[i]==nums[i+1])i++;//ignore duplicates of i
        }
        return ans;
    }
}