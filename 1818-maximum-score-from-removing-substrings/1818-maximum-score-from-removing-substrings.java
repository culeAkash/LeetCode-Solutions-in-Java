class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        int score = 0;
        int max = Math.max(x,y);
        int min = Math.min(x,y);
        int first = x > y ? 'a' : 'b';
        int second = x > y ? 'b' : 'a';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.empty()){
                st.push(ch);
            }else if(ch==second && st.peek()==first){
                score += max;
                st.pop();
            }else{
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.empty()){
            sb.append(st.pop());
        }

        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            if(st.empty()){
                st.push(ch);
            }else if(ch==second && st.peek()==first){
                score += min;
                st.pop();
            }else{
                st.push(ch);
            }
        }

        return score;
    }
}