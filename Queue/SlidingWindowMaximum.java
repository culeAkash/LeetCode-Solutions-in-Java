class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        
        int index = 0;
        for(int i=0;i<nums.length;i++){
            //reached l=out of bound limit take maxi and remove from front
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            
            //we have to maintain increasing order from front to last so dlete from last
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            
            //insert the curr Element,if it is the largest of the window it will go the first
            dq.offerLast(i);
            
            //only after a sliding window is iterated largest element is taken
            if(i>=k-1){
                ans[index++] = nums[dq.peekFirst()];
            }
            
        }
        
        return ans;
    }
}