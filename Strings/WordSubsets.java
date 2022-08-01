class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int maxFreq[] = getMaxFreq(words2);
        
        for(String word:words1){
            int freq[] = getFreq(word);
            //if for all characters in word the freq is >= the max freq of letters from words1 then it is added to ans
            boolean flag = true;
            
            for(int i=0;i<26;i++){
                if(freq[i]<maxFreq[i]){
                    flag = false;
                    break;
                }
            }
            
          if(flag)
                res.add(word);  
        }
        return res;
    }
    
    
    //Get max freq of each character in all the Strings in word 2 so that it is a standard for words in word1 to have minimum of that number of a particular character
    public int[] getMaxFreq(String[] words){
        int[] maxFreq = new int[26];
        
        for(String word:words){
            int[] freq = getFreq(word);
            
            for(int i=0;i<freq.length;i++)
                maxFreq[i] = Math.max(freq[i],maxFreq[i]);
        }
        
        return maxFreq;
    }
    
    public int[] getFreq(String word){
        int[] freq = new int[26];
        
        for(char c:word.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}