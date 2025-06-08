class Solution {
    public String robotWithString(String s) {
        int[] cnt = new int[26];

        for(char ch : s.toCharArray()){
            cnt[ch-'a']++;
        }

        Stack<Character> st = new Stack<>();

        StringBuilder res = new StringBuilder();
        char minChar = 'a';

        for(char ch : s.toCharArray()){
            st.push(ch);
            cnt[ch-'a']--;

            while(minChar!='z' && cnt[minChar - 'a']==0)
                minChar++;

            while(!st.empty() && st.peek() <= minChar){
                res.append(st.pop());
            }
        }
        return res.toString();
    }
}