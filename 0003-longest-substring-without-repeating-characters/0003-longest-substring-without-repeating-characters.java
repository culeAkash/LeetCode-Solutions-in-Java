class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();

        int maxLen = 0;
        int start = 0, end = 0;
        for(;end<s.length();end++){
            char ch = s.charAt(end);

            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);

            while(freqMap.get(ch) > 1){
                char ch1 = s.charAt(start);
                freqMap.put(ch1,freqMap.get(ch1)-1);
                start++;
            }

            maxLen = Math.max(end-start+1,maxLen);

        }

        return maxLen;
    }
}