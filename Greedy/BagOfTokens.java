class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length==0)
            return 0;
        
        if(tokens.length==1 && power<tokens[0])
            return 0;
        
        int start =0,end = tokens.length-1;
        Arrays.sort(tokens);
        
        int score = 0;
        while(start<end){
            if(power>=tokens[start]){
                power -= tokens[start++];
                score++;
            }
            else if(score>=1){
                power += tokens[end--];
                score--;
            }
            else{
                break;
            }
        }
        
        if(start==end){
            if(power>=tokens[start])
                score++;
        }
        return score;
        
    }
}