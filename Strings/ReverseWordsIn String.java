class Solution {
    public String reverseWords(String str) {
        str=str.trim();
        if(str.length()==0){
            return "";
        }
        String ans="";
        String temp="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                temp+=str.charAt(i);
            }
            else{
               if(temp.equals("")){
                   continue;
               }
                else{
                    ans=" "+temp+ans;
                    temp="";
                }
            }
        }
        ans=temp+ans;
        return ans;
    }
}