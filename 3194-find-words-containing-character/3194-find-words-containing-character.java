class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        for(String word : words){
            if(word.contains(x+"")){
                ans.add(index);
            }
            index++;
        }
        return ans;
    }
}