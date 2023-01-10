class Solution {
    public int countPairs(int[] nums) {
        //for counting the freq of all the numbers  in the array
        Map<Integer,Integer> map = new HashMap<>();

        map.put(nums[0],1);

        long res = 0;
        int mod = 1000000007;

        for(int j=1;j<nums.length;j++){
            int num = nums[j];
            int pow = 1;
            for(int i=0;i<22;i++){
                if(map.containsKey(pow - num)){
                    int count = map.get(pow - num);
                    res += count;
                    res %= mod;
                }
                pow *=2;
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }

        return (int)res;
    }
}