class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("*") && !tokens[i].equals("/") && !tokens[i].equals("-"))
                stack.push(Integer.parseInt(tokens[i]));
            else{
                int second = stack.pop();
                int first = stack.pop();
                int res  = 0;
                switch(tokens[i]){
                    case "+":{
                        res = first + second;
                        break;
                    }
                    case "*":{
                        res = first*second;
                        break;
                    }
                    case "/":{
                        res = first / second;
                        break;
                    }
                    case "-":{
                        res = first - second;
                        break;
                    }
                }
                System.out.println(res +" "+stack.size());
                stack.push(res);
            }    
        }
        return stack.pop();
    }
}