class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int i:nums)
            set.add(i);
        
        for(int i:nums){
            int max = 1,leftVal=i-1,rightVal=i+1;
            
            while(set.contains(leftVal)){
                max++;
                set.remove(leftVal--);
            }
            
            while(set.contains(rightVal)){
                max++;
                set.remove(rightVal++);
            }
            
            res= Math.max(res,max);
        }
        return res;
    }
}