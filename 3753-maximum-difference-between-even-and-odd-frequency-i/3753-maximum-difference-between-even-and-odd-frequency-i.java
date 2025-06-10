class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        int maxOdd = 0;
        int minEven = 101;

        for(int i=0;i<26;i++){
            if(freq[i]!=0 && (freq[i]&1)==0){
                minEven = Math.min(freq[i],minEven);
            }else{
                maxOdd = Math.max(freq[i],maxOdd);
            }
        }
        // System.out.println(maxOdd + " " + minEven);
        return maxOdd - minEven;
    }
}