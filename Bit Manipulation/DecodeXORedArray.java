class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length+1];
        ans[0] = first;
        
        int i=1;
        while(i<ans.length){
            ans[i] = ans[i-1] ^ encoded[i-1];
            i++;
        }
        
        return ans;
    }
}