class Solution {
  public int maxConsecutiveAnswers(String answerKey, int k) {
      int[] counts = new int[2];
      int maxFreq = 0;
      int start =0,end = 0;
      while(end<answerKey.length()){
          if(answerKey.charAt(end)=='T'){
              counts[0]++;
          }
          else{
              counts[1]++;
          }
          maxFreq = Math.max(maxFreq,Math.max(counts[0],counts[1]));

          if(end-start+1 > maxFreq + k){
              if(answerKey.charAt(start)=='T'){
                  counts[0]--;
              }
              else{
                  counts[1]--;
              }
              start++;
          }

          end++;
      }

      return answerKey.length() - start;
  }
}