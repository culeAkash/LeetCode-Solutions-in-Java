class Solution {
  public int longestSubarray(int[] nums) {
      int start = 0;
      int end = 0;
      int zeros = 0;

      int ans = 0;

      // move through the entire array
      for(;end<nums.length;end++){
          if(nums[end]==0)
              zeros++;

          while(zeros>1){
              if(nums[start]==0)
                  zeros--;
              start++;
          }

          ans = Math.max(ans,end-start+1-zeros);
      }
      return zeros == 0 ? ans - 1 : ans;
  }
}