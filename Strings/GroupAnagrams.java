class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s: strs){
            char[] ch = new char[26];
            for(char c : s.toCharArray())ch[c-'a']++;
            String str = String.valueOf(ch);
            if(!map.containsKey(str))map.put(str,new ArrayList<String>());
            map.get(str).add(s);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(List<String> sn : map.values())
            res.add(sn);
        return res;
    }
}