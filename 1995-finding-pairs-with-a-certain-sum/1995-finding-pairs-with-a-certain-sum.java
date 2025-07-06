class FindSumPairs {
    Map<Integer,Integer> freqMap;
    int[] nums1;
    int[] nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        freqMap = new HashMap<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int num : nums2){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
    }
    
    public void add(int index, int val) {
        if(freqMap.get(nums2[index])==1){
            freqMap.remove(nums2[index]);
        }else{
            freqMap.put(nums2[index],freqMap.get(nums2[index])-1);
        }
        nums2[index] += val;
        freqMap.put(nums2[index],freqMap.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int num : nums1){
            if(freqMap.containsKey(tot - num)){
                count += freqMap.get(tot - num); 
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */