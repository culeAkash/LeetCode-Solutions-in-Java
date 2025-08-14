class Solution {
    public String largestGoodInteger(String num) {
        int present = -1;
        String ans = "";
        for(int index=0;index<=num.length() - 3;index++){
            if(num.charAt(index) - '0' > present){
                if(num.charAt(index) == num.charAt(index+1) && num.charAt(index)==num.charAt(index+2)){
                    ans = num.charAt(index) + "" + num.charAt(index) + "" +num.charAt(index);
                    present = num.charAt(index) - '0';
                }
            }
        }
        return ans;
    }
}