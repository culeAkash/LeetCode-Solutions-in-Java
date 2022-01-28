class Solution {
    public List<List<String>> partition(String str) {
        List<List<String>> ans= new ArrayList<>();
        List<String> ds= new ArrayList<>();
        helper(str,ds,ans,0);
        return ans;
    }
    
    private static void helper(String str, List<String> ds, List<List<String>> ans, int index) {
        if(str.length()==0){
            return;
        }
        //if the index gets to the end of string
        if(index==str.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        //Now check partitioning at each index starting from the present index
        for(int i=index;i<str.length();i++){
            //if the present partition is palindrome
            if(isPalindrome(str,i,index)){
                //if palindrome take into the ans and call for remaining indices
                ds.add(str.substring(index, i+1));
                helper(str, ds, ans, i+1);
                ds.remove(ds.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str, int end, int start) {
        while(start<=end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
