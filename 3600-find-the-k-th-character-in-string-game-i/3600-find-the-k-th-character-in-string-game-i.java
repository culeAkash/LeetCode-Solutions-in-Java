class Solution {
    public char kthCharacter(int k) {
        StringBuilder init = new StringBuilder("a");

        while(init.length() < k){
            int size = init.length();
            for(int index = 0;index < size;index++){
                init.append((char)(init.charAt(index) + 1));
            }
        }

        return init.charAt(k-1);
    }
}