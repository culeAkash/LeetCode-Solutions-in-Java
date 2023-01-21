class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<Integer> dots = new ArrayList<>();
        helper(s,0,dots,ans);
        return ans;
    }

    public void helper(String str,int index,List<Integer> dots,List<String> ans){
        int remainingLength = str.length() - index;//Remaining string to be iterated
        int remainingIntegers = 4 - dots.size();//remaining integers that are needed to be formed

        if(remainingLength > remainingIntegers * 3 || remainingLength < remainingIntegers)
            return;

        //if three dots are already inserted to the IP then check for last part and add to ans
        if(dots.size()==3){
            if(checkValid(str,index,remainingLength)){
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for(int dot : dots){
                    sb.append(str.substring(last,last+dot));
                    last += dot;
                    sb.append('.');
                }
                sb.append(str.substring(index));
                ans.add(sb.toString());
            }
            return;
        }

        //iterate through all possible cases
        for(int curr=1;curr<=3 && curr<=remainingLength; curr++){
            dots.add(curr);
            if(checkValid(str,index,curr)){
                helper(str,index+curr,dots,ans);
            }
            dots.remove(dots.size()-1);
        }
    }

    public boolean checkValid(String s,int start,int length){
        return length == 1 || 
            (s.charAt(start) != '0' && 
             (length < 3 || 
              s.substring(start, start + length).compareTo("255") <= 0));
    }
}