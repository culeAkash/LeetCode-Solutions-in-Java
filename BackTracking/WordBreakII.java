class Solution {
    public List<String> wordBreak(String s, List<String> dict) {
        Set<String> dic = new HashSet<>();
        for(String S : dict)
            dic.add(S);
            
        List<String> res = new ArrayList<>();
        helper(res,dic,s,"");
        return res;
    }
    
     void helper(List<String> res,Set<String> dict,String str,String ansStr){
        if(str.length()==0){
            res.add(ansStr);
            return;
        }
        
        String tempStr="",ogAns = "",ogStr = "";
        
        for(int i=0;i<str.length();i++){
            tempStr += str.charAt(i);
            if(dict.contains(tempStr)){
                ogAns = ansStr;
                
                if(ansStr.length()==0)ansStr = tempStr;
                else ansStr += " " + tempStr;
                
                ogStr = str;
                str = str.substring(i+1);
                helper(res,dict,str,ansStr);
                
                //backtrack
                str = ogStr;
                ansStr = ogAns;
            }
        }
        
        
    }
}