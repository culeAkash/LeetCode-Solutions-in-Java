class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int contZero = 0;
        for(int num : nums){
            if(num!=0){
                ans += ((long)(((long)contZero)*((long)(contZero+1))))/2;
                contZero = 0;
                
            }else{
                contZero++;
            }
        }
        // System.out.println(nums.length + " " + contZero);
        if(contZero!=0){
            ans += ((long)(((long)contZero)*((long)(contZero+1))))/2;
        }
        // System.out.println(ans);

        return ans;
    }
}