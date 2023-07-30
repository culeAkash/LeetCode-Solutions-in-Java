class Solution {
    public int splitArray(int[] nums, int k) {
        int low = findMax(nums);
        int high = findSum(nums);

        while(low<=high){
            int mid = low + (high - low)/2;

            int subarrays = findSubarrayCount(mid,nums);

            if(subarrays<=k)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    public int findSubarrayCount(int mid,int[] arr){
        int subarrays = 1;
        int currSum = 0;

        for(int a : arr){
            currSum += a;
            if(currSum > mid){
                currSum = a;
                subarrays++;
            }
        }

        return subarrays;
    }


    public int findSum(int[] arr){
        int sum = 0;
        for(int a :arr) 
            sum += a;
        return sum;
    }

    public int findMax(int[] arr){
        int max = 0;
        for(int a :arr) 
            max = Math.max(a,max);
        return max;
    }
}