class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)
            return "";
        
        StringBuilder st = new StringBuilder(palindrome);
        
        int n = palindrome.length();
        
        if(n%2!=0){
            int mid = n/2;
            for(int i=0;i<st.length();i++){
            if(st.charAt(i)!='a' && mid!=i){
                st.replace(i,i+1,"a");
                return st.toString();
            }
        }
        }
        else{
        
        for(int i=0;i<st.length();i++){
            if(st.charAt(i)!='a'){
                st.replace(i,i+1,"a");
                return st.toString();
            }
        }
        }
        
        st.replace(st.length()-1,st.length(),"b");
        return st.toString();
        
        
    }
}