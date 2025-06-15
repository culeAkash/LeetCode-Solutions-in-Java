class Solution {
    int MOD = 1000000007;
    public int specialTriplets(int[] nums) {
        Map<Integer,List<Integer>> mpp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!mpp.containsKey(nums[i])){
                mpp.put(nums[i],new ArrayList<>());
            }
            mpp.get(nums[i]).add(i);
        }
        long res = 0;
        for(int index=1;index<nums.length-1;index++){
            if(!mpp.containsKey(nums[index]*2)){
                continue;
            }

            List<Integer> indices = mpp.get(nums[index]*2);

            int iCount = lessThan(indices,index);
            int kCount = indices.size() - lessThanEqualTo(indices,index);

            res = (res + (1L * iCount * kCount)) % MOD;
        }

        return (int)res;
    }

    // find lower limit
    int lessThan(List<Integer> indices,int index){
        int N = indices.size();
        int low = 0, high = N;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(indices.get(mid)<index){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return low;
    }

    int lessThanEqualTo(List<Integer> indices,int index){
        int N = indices.size();
        int low = 0, high = N;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(indices.get(mid)<=index){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return low;
    }
}