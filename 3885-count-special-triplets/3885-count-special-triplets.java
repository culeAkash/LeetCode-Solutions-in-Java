class Solution {
    int MOD = 1000000007;
    public int specialTriplets(int[] nums) {
        Map<Integer,Integer> suffixMap = new HashMap<>();

        for(int n : nums){
            suffixMap.put(n,suffixMap.getOrDefault(n,0)+1);
        }

        Map<Integer,Integer> prefixMap = new HashMap<>();

        long res = 0;
        for(int num : nums){
            if(suffixMap.containsKey(num)){
                if(suffixMap.get(num)==1){
                    suffixMap.remove(num);
                }else{
                    suffixMap.put(num,suffixMap.get(num)-1);
                }
            }

            int iCount = prefixMap.getOrDefault(2*num,0);
            int kCount = suffixMap.getOrDefault(2*num,0);

            res = (res + ((1L * iCount * kCount)% MOD )) % MOD;

            prefixMap.put(num,prefixMap.getOrDefault(num,0)+1);
        }

        return (int)res;
    }
}