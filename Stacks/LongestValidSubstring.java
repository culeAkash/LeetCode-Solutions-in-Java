class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()<=1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(stack.empty() || s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                if(s.charAt(stack.peek())=='('){
                    stack.pop();
                }
                else
                    stack.push(i);
            }
            
        }
        
        int max = 0;
        int curr = s.length();
        
        while(!stack.empty()){
            int ele = stack.pop();
            // System.out.println(ele);
            max = Math.max(max,curr-ele-1);
            curr = ele;
        }
        
        return Math.max(curr,max);
    }
}