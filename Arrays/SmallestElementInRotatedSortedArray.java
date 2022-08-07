class Solution {
    public int findMin(int[] nums) {
        int  n = nums.length;
        if(n==1)
            return nums[0];
        
        if(nums[0]<nums[n-1])//already sorted
            return nums[0];
        
        int start = 0, end = n-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[(mid+n-1)%n]>nums[mid] && nums[(mid+1)%n]>nums[mid])
                return nums[mid];//both left and right neighbours are greater then elem is least
                
            
            if(nums[end]>=nums[mid])//right is sorted search for min in left array
                end = mid - 1;
            else if(nums[start]<=nums[mid])//left subarray is sorted search in right
                start = mid + 1;
        }
        return -1;
    }
}