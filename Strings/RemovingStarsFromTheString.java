class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int i = 0;
        while(i<sb.length()-1){
            if(isChar(sb.charAt(i)) && sb.charAt(i+1)=='*'){
                sb.replace(i,i+2,"");
                if(i>0)
                    i--;
            }
            else
                i++;
        }
        return sb.toString();
    }
    
    public boolean isChar(char ch){
        return (ch>='a' && ch<='z');
    }
}