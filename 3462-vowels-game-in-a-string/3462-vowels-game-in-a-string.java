class Solution {
    public boolean doesAliceWin(String s) {
        int vowelCount = 0;

        for(char c : s.toCharArray()){
            if("aeiou".contains("" + c)){
                return true;
            }
        }

        return false;
    }
}