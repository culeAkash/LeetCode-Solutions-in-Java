class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
       if(startWord.equals(targetWord))
            return 0;
        Set<String> words = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        int level = 1;
        q.offer(startWord);
        
        for(String word : wordList)
            words.add(word);
            
        if(words.contains(startWord))
            words.remove(startWord);
            
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String front = q.poll();
                
                if(front.equals(targetWord))
                    return level;
                
                for(int i=0;i<front.length();i++){
                    for(char ch='a';ch<='z';ch++){
                        char[] replacedCharArray = front.toCharArray();
                        replacedCharArray[i] = ch;
                        String newString = new String(replacedCharArray);
                        if(words.contains(newString)){
                            // System.out.println(newString);
                            words.remove(newString);
                            q.offer(newString);
                        }
                    }
                }
            }
            level++;
        }
        return 0; 
    }
}