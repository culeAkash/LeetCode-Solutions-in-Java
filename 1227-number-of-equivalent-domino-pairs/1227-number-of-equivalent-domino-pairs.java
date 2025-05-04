class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] sumCount = new int[100];

        int ans = 0;
        for(int[] domino : dominoes){
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ans += sumCount[val];
            sumCount[val]++;
        }

        return ans;
    }
}