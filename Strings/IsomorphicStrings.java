class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==null){
                if(!map.containsValue(t.charAt(i)))
                    map.put(s.charAt(i),t.charAt(i));
                else
                    return false;
            }
            else if(map.get(s.charAt(i))!=t.charAt(i))
                return false;
        }
        return true;
    }
}