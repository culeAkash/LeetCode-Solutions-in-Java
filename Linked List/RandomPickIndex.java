class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    public Solution(int[] nums) {
        int index = 0;
        while(index<nums.length){
            if(!map.containsKey(nums[index])){
                map.put(nums[index],new ArrayList<Integer>());
            }    
            map.get(nums[index]).add(index);
            index++;
        }
    }
    
    public int pick(int target) {
        List<Integer> temp = map.get(target);

        int size = temp.size();

        int rand = (int)(Math.random()*size);

        return temp.get(rand);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */