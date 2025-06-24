class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndices = new ArrayList<>();
        int i = 0;
        for(int num : nums){
            if(num==key){
                keyIndices.add(i);
            }
            i++;
        }

        List<Integer> res = new ArrayList<>();
        for(int index = 0;index < nums.length;index++){
            for(int ind : keyIndices){
                if(Math.abs(index - ind) <= k){
                    res.add(index);
                    break;
                }
            }
        }

        return res;
    }
}