class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        int run = 1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(i-1)){
                ans += (run - 1);
                run = 1;
            }else{
                run++;
            }
        }

        ans += (run-1);
        return ans;
    }
}