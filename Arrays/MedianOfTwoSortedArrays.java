class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;


        if(n > m)
            return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int high = n;
        int mid = (n+m+1)/2;

        while(low<=high){
            int cut1 = (low+high)/1;
            int cut2 = mid - cut1;

            int left1 = cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1 = cut1==nums1.length ? Integer.MAX_VALUE : nums1[cut1];

            int right2 = cut2==nums2.length ? Integer.MAX_VALUE : nums2[cut2];


            if(left1<=right2 && left2<=right1){
                if((nums1.length+nums2.length)%2!=0)
                    return Math.max(left1,left2);
                return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
            }
            else if(left1 > right2){
                high = cut1 - 1;
            }
            else
                low = cut1 + 1;
        }

        return 0.0;
    }
}