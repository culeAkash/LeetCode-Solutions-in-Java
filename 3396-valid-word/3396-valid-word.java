class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3)
            return false;

        boolean isVowelPresent = false,isConsonentPresent = false;

        for(char ch : word.toCharArray()){
            if(isVowel(ch)){
                isVowelPresent = true;
            }else if(isConsonent(ch)){
                isConsonentPresent = true;
            }else if(!isDigit(ch)){
                return false;
            }
        }

        return isVowelPresent && isConsonentPresent;
        
    }

    boolean isVowel(char ch){
        return ("aAeEiIoOuU").contains(ch+"");
    }

    boolean isConsonent(char ch){
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
            if(isVowel(ch)){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

    boolean isDigit(char ch){
        return (ch>='0' && ch <= '9');
    }
}