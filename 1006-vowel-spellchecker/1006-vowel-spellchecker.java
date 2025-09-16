class Solution {
    Set<String> perfectWords;
    Map<String,String> devowelWords;
    Map<String,String> capWords;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        perfectWords = new HashSet<>();
        devowelWords = new HashMap<>();
        capWords = new HashMap<>();

        for(String word : wordlist){
            perfectWords.add(word);

            String lower = word.toLowerCase();
            capWords.putIfAbsent(lower,word);

            String devowl = devowel(lower);
            devowelWords.putIfAbsent(devowl,word);
        }
        int N = queries.length;
        String[] ans = new String[N];

        for(int i=0;i<N;i++){
            if(perfectWords.contains(queries[i])){
                ans[i] = queries[i];
                continue;
            }

            String lower = queries[i].toLowerCase();
            if(capWords.containsKey(lower)){
                ans[i] = capWords.get(lower);
                continue;
            }

            String devowl = devowel(lower);
            if(devowelWords.containsKey(devowl)){
                ans[i] = devowelWords.get(devowl);
                continue;
            }

            ans[i] = "";
        }

        return ans;
    }

    String devowel(String word){
        StringBuilder s = new StringBuilder();
        for(char ch : word.toCharArray()){
            if(isVowel(ch))
                s.append("*");
            else
                s.append(ch);
        }
        return s.toString();
    }

    boolean isVowel(char ch){
        return "aeiou".contains(ch+"");
    }
}