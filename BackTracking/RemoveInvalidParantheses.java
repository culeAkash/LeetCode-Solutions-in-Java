class Solution {
    public Map<String,Integer> map = new HashMap<>();
    public HashSet<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        solve(s,getinvalid(s),ans);
        return ans;
    }
    
    public int getinvalid(String s){
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(stack.size() > 0 && stack.peek() == '('){
                     stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }   
            i++;
        }
        return stack.size();
    }
    
    public void solve(String str,int invalid,List<String> res){
       
      
        if(invalid < 0){
            return;
        }
        if(invalid == 0){
           int now = getinvalid(str);
           if(now == 0){
               if(!map.containsKey(str)){
                   map.put(str,1);
                   res.add(str);
               }
           }
           return;
        }
        
        for(int i = 0; i<str.length(); i++){
            String left = str.substring(0,i);
            String right = str.substring(i+1);
            if(set.contains(left+right) == false){
                set.add(left+right);
                 solve(left+right,invalid-1,res);
            }
        }
    }
}