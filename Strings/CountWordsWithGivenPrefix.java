class Solution {
    public int prefixCount(String[] words, String pref) {
        if(words.length==0)
            return 0;
        
        int count=0;
        for(String s:words){
            if(s.startsWith(pref))
                count++;
        }
        return count;
    }
}