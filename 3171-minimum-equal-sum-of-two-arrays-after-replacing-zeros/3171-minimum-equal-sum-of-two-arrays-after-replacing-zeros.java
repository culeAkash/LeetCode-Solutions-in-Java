class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long zeroCount1 = 0,zeroCount2 = 0,sum1 = 0, sum2=0;

        for(int num : nums1){
            if(num==0)
                zeroCount1++;
            else
                sum1 += num;
        }

        for(int num : nums2){
            if(num==0)
                zeroCount2++;
            else
                sum2 += num;
        }


        if(zeroCount2 == 0 && (sum2 - sum1) < zeroCount1){
            return -1;
        }else if(zeroCount1==0 && (sum1-sum2) < zeroCount2){
            return -1;
        }

        return Math.max(zeroCount1+sum1,zeroCount2+sum2);

        


    }
}