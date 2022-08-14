class Solution {
    public String longestPalindrome(String S) {
        int start = 0;
        int length = 1;
        
        //for even length substring
        for(int i=0;i<S.length();i++){
            int low =  i - 1;
            int high = i;
            
            while(low>=0 && high<S.length() && S.charAt(low)==S.charAt(high)){
                if(high-low+1>length){
                    start = low;
                    length = high - low + 1;
                }
                low--;
                high++;
            }
        }
        
        // for odd length substring
        for(int i=0;i<S.length();i++){
            int low =  i - 1;
            int high = i + 1;
            
            while(low>=0 && high<S.length() && S.charAt(low)==S.charAt(high)){
                if(high-low+1>length){
                    start = low;
                    length = high - low + 1;
                }
                low--;
                high++;
            }
        }
        
        return S.substring(start,start+length);
        
    }
}