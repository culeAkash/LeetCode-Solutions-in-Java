class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();
        int start = 0;
        int maxi = 0;
        for(int end = 0;end < s.length();end++){
            char ch = s.charAt(end);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);

            while(freqMap.get(ch) > 2){
                freqMap.put(s.charAt(start),freqMap.get(s.charAt(start))-1);
                start++;
            }
            // System.out.println(start + " " + end);
            maxi = Math.max(maxi,end-start+1);

        }

        return maxi;
    }
}