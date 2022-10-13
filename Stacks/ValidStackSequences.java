class Solution {
    public boolean validateStackSequences(int[] ip, int[] op) {
        Stack<Integer> stack = new Stack<>();
        
        int j = 0;
        for(int i=0;i<ip.length;i++){
            stack.push(ip[i]);
            
            while(!stack.empty() && stack.peek()==op[j]){
                stack.pop();
                j++;
            }
        }
        
        return j==ip.length;
    }
}