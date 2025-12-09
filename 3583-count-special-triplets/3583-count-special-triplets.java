class Solution {
    int MOD = 1000000007;
    public int specialTriplets(int[] nums) {
        Map<Integer,Integer> suffixFreq = new HashMap<>();

        for(int num : nums)
            suffixFreq.put(num,suffixFreq.getOrDefault(num,0)+1);

        
        long ans = 0;
        Map<Integer,Integer> prefixFreq = new HashMap<>();
        for(int num : nums){
            if(suffixFreq.get(num)==1)suffixFreq.remove(num);
            else suffixFreq.put(num,suffixFreq.get(num)-1);

            int i = suffixFreq.getOrDefault(num*2,0);
            int j = prefixFreq.getOrDefault(num*2,0);

            ans = (ans + ((1L * i * j) % MOD)) % MOD;

            prefixFreq.put(num,prefixFreq.getOrDefault(num,0)+1);
        }

        return (int)ans;
    }
}