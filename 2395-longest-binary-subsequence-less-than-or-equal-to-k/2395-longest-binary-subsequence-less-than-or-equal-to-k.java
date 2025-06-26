class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int power = 0;
        for(int index = 0;index < s.length();index++){
            char ch = s.charAt(s.length() - index - 1);
            if(ch=='1'){
                if(power < 32 && k - (1<<power) >= 0){
                    k -= (1<<power);
                    count++;
                }
            }else{
                count++;
            }
            power++;
        }
        return count;
    }
}