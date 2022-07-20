class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] dup = new int[nums.length*2];
        
        for(int i=0;i<dup.length;i++){
            dup[i] = nums[i%nums.length];
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=dup.length-1;i>=0;i--){
            
            while(!stack.empty() && stack.peek()<=dup[i])
                stack.pop();
            
            if(stack.empty())
                nums[i%nums.length] = -1; 
            else
                nums[i%nums.length] = stack.peek();
                
            stack.push(dup[i]);
            
        }
        return nums;
    }
}