class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;

        for(int i=0;i<26;i++){
            char ch = (char)('a'+i);
            int start =-1,end=-1;
            boolean[] freq = new boolean[26];

            for(int index=0;index<s.length();index++){
                char c = s.charAt(index);
                if(start==-1 && ch==c)start=index;
                if(ch==c)end=index;
            }

            int index = start + 1;
            int count = 0;
            while(index < end){
                if(!freq[s.charAt(index)-'a']){
                    count++;
                    freq[s.charAt(index)-'a'] = true;
                }
                index++;
            }
            // System.out.println(count);
            ans += count;
        }

        return ans;
    }
}