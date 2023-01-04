class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1)
            return true;
        boolean isCapital =  true;
        if(!('A'<= word.charAt(0) && word.charAt(0)<='Z')){
            isCapital = false;
        }
        else{
            isCapital = ('A'<= word.charAt(1) && word.charAt(1)<='Z');
        }
        boolean capitalRight = true;
        if(isCapital){
            for(int i=1;i<word.length();i++){
                if(!('A'<= word.charAt(i) && word.charAt(i)<='Z'))
                    capitalRight =  false;
            }
        }
        else{
            for(int i=1;i<word.length();i++){
                if(!('a'<= word.charAt(i) && word.charAt(i)<='z'))
                    capitalRight =  false;
            }
        }
        return capitalRight; 
    }
}