class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L, right = 10000000000L;

        while(left<=right){
            long mid = left + (right - left) / 2;
            long count = 0;
            for(int num : nums1){
                count += countLessThanEqual(nums2,mid,num);
            }

            if(count < k){
                left = mid + 1;
            }else{
                right = mid - 1; 
            }
        }
        return left;
    }

    int countLessThanEqual(int[] nums,long target,long x){
        int left = 0, right = nums.length - 1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            long prod = (long) nums[mid] * x;
            if((x>=0 && prod > target) || (x <0 && prod <= target)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        if(x >=0)
            return left;
        else
            return nums.length - left;
    }
}