class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        char[] c = s.toCharArray();
        int count = 0;
        
        for(String word: map.keySet()){
            
            char[] w = word.toCharArray();
            int i = 0;
            int j = 0;
            
            while(i<c.length && j<w.length){
                if(c[i]==w[j]){
                    i++;
                    j++;
                }
                else
                    i++;
            }
            
            if(j==w.length)
               count+= map.get(word); 
        }
        
        return count;
    }
}