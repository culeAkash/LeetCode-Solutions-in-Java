class Solution {
    public int beautySum(String s) {
        int ans = 0;

        for(int i=0;i<s.length();i++){
            int[] freq = new int[26];

            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;

                int min = 500;
                for(int k=0;k<26;k++){
                    if(freq[k]>=1){
                        min = Math.min(min,freq[k]);
                    }
                }

                int max = 0;
                for(int k=0;k<26;k++){
                    // if(freq[k]>=1){
                        max = Math.max(max,freq[k]);
                    // }
                }

                ans += max-min;
            }
        }

        return ans;
    }
}