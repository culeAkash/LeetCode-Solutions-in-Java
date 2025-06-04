class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
            return word;

        String last = helper(word);
        int m = last.length();

        return last.substring(0,Math.min(m,word.length()-numFriends+1));
    }

    String helper(String word){
        int i = 0,j = 1,n = word.length();
        while(j < n){
            int k = 0;
            while(j+k < n && word.charAt(i+k)==word.charAt(j+k)){
                k++;
            }

            if(j+k<n && word.charAt(i+k)<word.charAt(j+k)){
                int t = i;
                i = j;
                j = Math.max(j+1,t+k+1);
            }else{
                j=j+k+1;
            }
        }
        return word.substring(i);
    }
}