class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0)+1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> e : set){
            if(e.getValue()==nums.length)
                res.add(e.getKey());
        }
        
        return res;
    }
}