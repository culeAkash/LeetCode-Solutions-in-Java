class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArr = new int[26];

        for(int i=0;i<26;i++){
            orderArr[order.charAt(i)-'a'] = i;
        }

        // for(int i : orderArr)
        //     System.out.print(i + " ");
        // System.out.println();

        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];

            int length = Math.min(s1.length(),s2.length());
            int j = 0;
            while(j < length){
                if(s1.charAt(j)!=s2.charAt(j)){
                    int o1 = orderArr[s1.charAt(j)-'a'];
                    int o2 = orderArr[s2.charAt(j)-'a'];
                    // System.out.println(o1 + " " + o2);
                    if(o1>o2)
                        return false;
                    break;
                }
                j++;
            }

            if(j==length){
                if(s1.length()>s2.length())
                    return false;
            }
        }
        return true;
    }
}