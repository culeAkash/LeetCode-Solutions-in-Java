class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character,String> matches = new HashMap<>();

        if(pattern.length()!=words.length)
            return false;

        for(int i=0;i<pattern.length();i++){
            char ch =  pattern.charAt(i);
            String word = words[i];

            if(matches.containsKey(ch) && !matches.get(ch).equals(word))
                return false;

            if(matches.containsValue(word) && !matches.containsKey(ch))
                return false;
            
            else
                matches.put(ch,word);
        }
        return true;
        
    }
}