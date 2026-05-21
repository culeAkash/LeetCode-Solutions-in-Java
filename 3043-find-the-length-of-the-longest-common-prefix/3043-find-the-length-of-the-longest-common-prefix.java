class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxLen = 0;

        Set<Integer> prefix = new HashSet<>();

        for(int num : arr1){
            while(num > 0){
                prefix.add(num);
                num /= 10;
            }
        }

        for(int num : arr2){
            while(num > 0){
                if(prefix.contains(num)){
                    int cnt = prefixCount(num);
                    maxLen = Math.max(maxLen,cnt);
                }
                num /= 10;
            }
        }

        return maxLen;
    }

    int prefixCount(int num){
        int cnt = 0;
        while(num > 0){
            cnt++;
            num /= 10;
        }
        return cnt;
    }
}