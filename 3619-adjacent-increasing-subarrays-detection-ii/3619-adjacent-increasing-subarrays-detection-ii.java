class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int currCount = 1;
        int prevCount = 0;
        int ans = 1;
        int index = 1;
        int N = nums.size();
        while(index < N){
            if(nums.get(index-1) < nums.get(index)){
                currCount++;
            }else{
                // System.out.println(index + " " + currCount);
                ans = Math.max(ans,Math.min(prevCount,currCount));
                ans = Math.max(ans,currCount/2);
                prevCount = currCount;
                currCount = 1;
                // System.out.println(ans);
            }
            index++;
        }
        ans = Math.max(ans,Math.min(prevCount,currCount));
        ans = Math.max(ans,currCount/2);

        return ans;
    }
}