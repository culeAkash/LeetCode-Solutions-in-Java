class Solution {
    public long distinctNames(String[] ideas) {
        long ans = 0;

        Set<String>[] initialGroup = new HashSet[26];

        for(int i=0;i<26;i++){
            initialGroup[i] = (new HashSet<String>());
        }

        //add all the strings in group by their initial characters
        for(String idea : ideas){
            char initial = idea.charAt(0);
            initialGroup[initial-'a'].add(idea.substring(1));
        }

        //tryo out all the initials for matching
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                long common = 0;

                //if one set's suffix is present in another set's suffix list then that suffix must not be considered and it will surely be present in the ideas
                for(String idea : initialGroup[i]){
                    if(initialGroup[j].contains(idea))
                        common++;
                }

                ans += 2 * (initialGroup[i].size()-common)*(initialGroup[j].size()-common);
                   
            }
        }
        return ans;
    }
}