class Solution {
    public List<Integer> diffWaysToCompute(String str) {
        return helper(str);
    }
    
    List<Integer> helper(String str){
        List<Integer> res = new ArrayList<>();
        if(str.length()==0){
            res.add(0);
            return res;
        }
        
        if(str.length()==1 || str.length()==2){
            res.add(Integer.parseInt(str));
            return res;
        }
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='+' || str.charAt(i)=='*' || str.charAt(i)=='-'){
                List<Integer> left = helper(str.substring(0,i));
                List<Integer> right = helper(str.substring(i+1));
                System.out.println(left+" "+right);
                for(Integer l: left){
                    for(Integer r: right){
                        int ans = 0;
                        if(str.charAt(i)=='+')
                            ans = l + r;
                        else if(str.charAt(i)=='*')
                            ans = l * r;
                        else if(str.charAt(i)=='-')
                            ans = l - r;
                        res.add(ans);
                    }
                }
            }
            
        }
        return res;
    }
}