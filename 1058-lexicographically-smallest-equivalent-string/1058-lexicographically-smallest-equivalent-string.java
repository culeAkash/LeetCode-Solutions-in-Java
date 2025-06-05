class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] mins = new int[26];
        Map<Integer,Set<Integer>> chars = new HashMap<>();
        for(int i=0;i<26;i++){
            mins[i] = i;
            chars.put(mins[i],new HashSet<>(Set.of(mins[i])));
        }
        int N = s1.length();
        for(int index=0;index<N;index++){
            int ch1 = s1.charAt(index) - 'a';
            int ch2 = s2.charAt(index) - 'a';

            modify(ch1,ch2,mins,chars);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            sb.append((char)('a' + mins[baseStr.charAt(i) - 'a']));
        }

        return sb.toString();
    }

    void modify(int index1,int index2,int[] mins,Map<Integer,Set<Integer>> chars){
        int val1 = mins[index1];
        int val2 = mins[index2];

        if(val1<val2){
            Set<Integer> charsVal2 = chars.get(val2);
            for(int val : charsVal2){
                mins[val] = val1;
                chars.get(val1).add(val);
            }
            charsVal2.clear();
            chars.put(val2,charsVal2);
        }else if(val1>val2){
            Set<Integer> charsVal1 = chars.get(val1);
            for(int val : charsVal1){
                mins[val] = val2;
                chars.get(val2).add(val);
            }
            charsVal1.clear();
            chars.put(val1,charsVal1);
        }
    }
}