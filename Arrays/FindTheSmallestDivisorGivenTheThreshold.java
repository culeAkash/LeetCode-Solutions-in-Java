class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MIN_VALUE;

        for(int num : nums){
            end = Math.max(end,num);
        }

        while(start<=end){
            int mid = start + (end-start)/2;

            int ans = find(nums,mid);

            if(ans<=threshold)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }

    public int find(int[] nums,int mid){
        int ans = 0;

        for(int num : nums){
            ans += (int)Math.ceil(num*(1.0)/mid);
        }

        return ans;
    }
}