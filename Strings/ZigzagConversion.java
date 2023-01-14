class Solution {
    public String convert(String s, int numRows) {
        List<List<Character>> strs = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            strs.add(new ArrayList<Character>());
        }

        // for(String str : strs){
        //     System.out.print(str);
        // }

        int index = 0;
        int fact = 1;

        int n = s.length();

        while(index < n){
            int i = 0;
            fact = 1;
            while(index < n && i < numRows){
                strs.get(i).add(s.charAt(index++));
                i += fact;
            }

            fact = -1;
            i = numRows - 2;
            while(index < n && i>0){
                strs.get(i).add(s.charAt(index++));
                i += fact;
            }
        }

        String ans = "";

        for(List<Character> chars : strs){
            for(char ch : chars){
                ans += ch;
            }
        }

        return ans;
    }
}