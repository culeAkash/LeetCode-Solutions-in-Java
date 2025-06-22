class Solution {
    public String[] divideString(String s, int k, char fill) {
        int partitions = s.length() / k;

        partitions += (s.length() % k) > 0 ? 1 : 0;

        String[] res = new String[partitions];

        int index = 0;
        int resIndex = 0;

        while(index < s.length()){
            StringBuilder t = new StringBuilder();
            int k1 = k;
            while(index < s.length() && k1-- > 0){
                t.append(s.charAt(index));
                index++;
            }

            if(t.length() < k){
                k1 = k - t.length();
                while(k1-->0){
                    t.append(fill);
                }
            }

            res[resIndex++] = t.toString();
        }
        return res;
    }
}