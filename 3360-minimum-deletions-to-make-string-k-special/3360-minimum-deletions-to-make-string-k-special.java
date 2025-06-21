class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freqs = new int[26];

        for(char ch : word.toCharArray()){
            freqs[ch-'a']++;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freqs[i]!=0){
                int floor = freqs[i];
                int temp = 0;
                for(int j=0;j<26;j++){
                    if(freqs[j]!=0 && i!=j){
                        if(freqs[j] < floor){
                            temp += freqs[j];
                        }else if(freqs[j] - floor > k){
                            temp += freqs[j] - floor - k;
                        }
                    }
                }
                res = Math.min(res,temp);
            }
        }
        return res;
    }
}