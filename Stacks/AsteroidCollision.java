class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int a:asteroids){
            if(a>0){
                stack.push(a);
            }
            else{
                while(!stack.empty() && stack.peek()>0 && stack.peek()<-a)
                    stack.pop();
                
                if(stack.size()>0 && stack.peek()== -a)
                    stack.pop();
                else if(!stack.empty() && stack.peek()>-a)
                    continue;
                else
                    stack.push(a);
            }
        }
        int[] ans = new int[stack.size()];
        int i = ans.length-1;
        while(!stack.empty())
            ans[i--] = stack.pop();
        return ans;
    }
}