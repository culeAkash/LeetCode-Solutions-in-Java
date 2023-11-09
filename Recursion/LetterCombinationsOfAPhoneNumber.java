class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
            return res;

        Map<Character,String> letters = new HashMap<>();

        letters.put('2',"abc");
        letters.put('3',"def");
        letters.put('4',"ghi");
        letters.put('5',"jkl");
        letters.put('6',"mno");
        letters.put('7',"pqrs");
        letters.put('8',"tuv");
        letters.put('9',"wxyz");

        
        helper(res,letters,digits,"",0);

        return res;
    }


    public void helper(List<String> res,Map<Character,String> letters,String digits,String ans,int index){
        if(index>=digits.length()){
            res.add(ans);
            return;
        }

        char ch = digits.charAt(index);
        String letterStr = letters.get(ch);
        for(int i=0;i<letterStr.length();i++){
            helper(res,letters,digits,ans+letterStr.charAt(i),index+1);
        }
    }
}