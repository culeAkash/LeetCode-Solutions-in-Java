class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int ans = 0;
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        int flag = 0;
        for(String word : words){
            if(word.charAt(0)==word.charAt(1) && map.containsKey(word)){
                int count = map.get(word);
                if((count&1)==1){
                    flag = 1;
                }
                ans += (count/2) * 4;
                map.remove(word);
            }else{
                String rev = "" + word.charAt(1) + word.charAt(0);

                if(map.containsKey(word) && map.containsKey(rev)){
                    ans += 4 * (Math.min(map.get(word),map.get(rev)));
                    map.remove(word);
                    map.remove(rev);
                }
            }
        }

        if(flag==1)
            ans += 2;

        return ans;
        

    }
}