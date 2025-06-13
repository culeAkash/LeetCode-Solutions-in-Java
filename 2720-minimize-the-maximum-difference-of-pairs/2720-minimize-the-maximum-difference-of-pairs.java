class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int N = nums.length;
        int low = 0,high = nums[N-1] - nums[0];

        while(low<=high){
            int mid = low + (high - low) / 2;

            if(countPairs(mid,nums,N) >= p){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    int countPairs(int threshold,int[] nums,int N){
        int index=0,count = 0;

        while(index < N-1){
            if(nums[index+1]-nums[index] <= threshold){
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
}