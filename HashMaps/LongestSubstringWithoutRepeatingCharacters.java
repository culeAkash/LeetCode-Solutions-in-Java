class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
            return s.length();
        Set<Character> chars = new HashSet<>();

        int slow = 0,fast = 0;
        int max = 1;
        while(fast!=s.length()){
            char curr = s.charAt(fast);

            if(chars.contains(curr)){
                while(s.charAt(slow)!=curr){
                    chars.remove(s.charAt(slow));
                    slow++;
                }
                chars.remove(curr);
                slow++;
            }
            max = Math.max(max,fast-slow+1);
            chars.add(curr);
            // System.out.println(max+" "+fast+" "+slow);
            fast++;
        }
        return max;
    }
}