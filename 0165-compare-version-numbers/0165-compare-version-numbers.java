class Solution {
    public int compareVersion(String version1, String version2) {
        List<String> v1 = split(version1);
        List<String> v2 = split(version2);

        int M = Math.min(v1.size(),v2.size());
        int N = Math.max(v1.size(),v2.size());
        // System.out.println(v1.size() + " " + v2.size());
        int index = 0;
        for(;index<M;index++){
            int intV1 = Integer.parseInt(v1.get(index));
            int intV2 = Integer.parseInt(v2.get(index));

            // System.out.println(intV1 + " " + intV2);

            if(intV1 < intV2)return -1;
            else if(intV1 > intV2)return 1;
        }

        while(index < N){
            int intV1 = 0;
            int intV2 = 0;

            

            if(index < v1.size())intV1 = Integer.parseInt(v1.get(index));
            else intV2 = Integer.parseInt(v2.get(index));

            // System.out.println(intV1 + " " + intV2);

            if(intV1 < intV2)return -1;
            else if(intV1 > intV2)return 1;
            index++;
        }

        return 0;
    }

    private List<String> split(String v){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<v.length();i++){
            if(v.charAt(i) == '.'){
                res.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            sb.append(v.charAt(i));
        }
        res.add(sb.toString());
        return res;
    }
}