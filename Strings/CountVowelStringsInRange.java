class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean[] isValid = new boolean[words.length];
        
        for(int i=0;i<words.length;i++){
            if(words[i].length()==1 && isVowel(words[i].charAt(0)))isValid[i]=true;
            else{
                char first = words[i].charAt(0);
                char last = words[i].charAt(words[i].length()-1);
                
                if(isVowel(first) && isVowel(last))
                    isValid[i] = true;
            }
        }
        int counts[] = new int[words.length];
        
        int c = 0;
        
        for(int i=0;i<words.length;i++){
            
            if(isValid[i])
                c++;
            
            counts[i] = c;
        }
        
        int[] ans = new int[queries.length];
        
        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            
            int sec = query[0]==0 ? 0 : counts[query[0] - 1];
            
            ans[i] = counts[query[1]] - sec; 
            
        }
        
        return ans;
    }
    
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }
}