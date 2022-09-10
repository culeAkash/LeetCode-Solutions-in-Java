class Solution {
    public String largestOddNumber(String num) {
        String res = "";
        int index = -1;
        for(int i=num.length()-1;i>=0;i--){
            if((num.charAt(i)-'0')%2!=0){
                index = i;
                break;
            }
        }
        return num.substring(0,index+1);
    }
}