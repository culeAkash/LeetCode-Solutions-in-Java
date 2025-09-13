class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        int maxCons = 0;
        int maxVow = 0;
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;

            if("aeiou".contains(ch+"")){
                maxVow = Math.max(maxVow,freq[ch-'a']);
            }else{
                maxCons = Math.max(maxCons,freq[ch-'a']);
            }
        }

        return maxCons + maxVow;
    }
}