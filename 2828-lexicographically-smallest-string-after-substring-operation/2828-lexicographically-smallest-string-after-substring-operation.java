class Solution {
    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int N = sb.length();
        int index = 0;
        while(index < N && s.charAt(index)=='a')index++;

        if(index==N){
            sb.setCharAt(N-1,'z');
            return sb.toString();
        }

        while(index < N && s.charAt(index)!='a'){
            sb.setCharAt(index,(char)(s.charAt(index)-1));
            index++;
        }

        return sb.toString();
    }
}