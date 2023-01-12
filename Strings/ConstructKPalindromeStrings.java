class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k)
            return false;

        int[] counts = new int[26];


        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
        }

        int oddCount = 0;
        for(int i=0;i<26;i++){
            if(counts[i]%2!=0)
                oddCount++;
        }

        return oddCount>k ? false : true;
    }
}