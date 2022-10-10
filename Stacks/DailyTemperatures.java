class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[]  res = new int[temp.length];
        
        for(int i=temp.length-1;i>=0;i--){
            while(!stack.empty() && temp[stack.peek()]<=temp[i])
                stack.pop();
            
            if(stack.size()==0)
                res[i] = 0;
            else{
                res[i] = stack.peek() - i;
            }
            
            stack.push(i);
        }
        
        return res;
    }
}