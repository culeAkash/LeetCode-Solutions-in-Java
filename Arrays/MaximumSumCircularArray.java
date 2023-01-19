class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxRight[] = new int[n];
        int suffixSum = nums[n-1];
        maxRight[n-1] = nums[n-1];

        for(int index = n-2;index>=0;index--){
            suffixSum += nums[index];
            maxRight[index] = Math.max(suffixSum,maxRight[index+1]); 
        } 

        int specialSum = Integer.MIN_VALUE;
        int prefixSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int index=0;index<n;index++){
            prefixSum += nums[index];

            //plain old kadane's Algo
            currSum += nums[index];
            // System.out.println(currSum);
            maxSum = Math.max(currSum,maxSum);
            // System.out.println(maxSum);

            currSum = Math.max(0,currSum); 

            //get suffix sum of index greater than current Index to get special sum
            if(index < n-1){
                specialSum = Math.max(specialSum,prefixSum + maxRight[index + 1]);
            }
        }

        // System.out.println(maxSum+" "+specialSum);
        return Math.max(maxSum,specialSum);
    }
}