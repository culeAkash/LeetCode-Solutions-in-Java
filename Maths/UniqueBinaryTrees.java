//Number of unique binary trees of size n is equal to nth catalan number
class Solution {
    public int numTrees(int n) {
        int[] catalan = new int[n+1];
        catalan[0] = catalan[1] = 1;
        
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++)
                catalan[i] += catalan[j] * catalan[i-j-1];
        }
        return catalan[n];
    }
}