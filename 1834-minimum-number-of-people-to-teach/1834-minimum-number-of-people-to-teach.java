class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> languageSet = new ArrayList<>();
        for(int[] language : languages){
            Set<Integer> set = Arrays.stream(language).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
            languageSet.add(set);
        }

        Set<Integer> notFriends = new HashSet<>();
        for(int[] friendship : friendships){
            int f1 = friendship[0];
            int f2 = friendship[1];

            Set<Integer> s1 = languageSet.get(f1-1);
            Set<Integer> s2 = languageSet.get(f2-1);

            if(!s1.stream().anyMatch(s2::contains)){
                notFriends.add(f1);
                notFriends.add(f2);
            }
        }

        int res = 0;
        int max = 0;
        int[] counts = new int[n];
        // find the language appearing most
        for(int f : notFriends){
            Set<Integer> s = languageSet.get(f-1);
            for(int l : s){
                counts[l-1]++;
            }
        }

        for(int c : counts){
            max = Math.max(c,max);
        }

        return notFriends.size() - max;
    }
}