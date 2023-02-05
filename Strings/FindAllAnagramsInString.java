class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length())
            return res;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i=0;i<p.length();i++){
            map1[p.charAt(i)-'a']++;
            map2[s.charAt(i)-'a']++;
        }

        int i = 0;
        for(; i<s.length() - p.length();i++){
            if(matches(map1,map2))
                res.add(i);

            map2[s.charAt(i)-'a']--;
            map2[s.charAt(i + p.length())-'a']++;
        }

    if(matches(map1,map2))
        res.add(i);
    return res;
    }

    public boolean matches(int[] map1,int[] map2){
        for(int i=0;i<26;i++){
            if(map1[i]!=map2[i])
                return false;
        }
        return true;
    }
}