class Solution {
    public int minFlipsMonoIncr(String s) {
        int ans =0, num = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                //we can flip it or we can flip all 1 s before it
                ans =  Math.min(num,ans+1);
            }
            else{
                num++;
            }
        }
        return ans;
    }
}