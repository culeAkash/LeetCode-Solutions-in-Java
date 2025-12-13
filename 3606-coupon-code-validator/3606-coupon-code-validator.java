class Solution {
    Map<String, Integer> priority = new HashMap<>();
        
    public List<String> validateCoupons(String[] codes, String[] businessLines, boolean[] isActives) {
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);
        List<List<String>> pairs = new ArrayList<>();

        int N = codes.length;

        for(int index = 0;index < N;index++){
            String code = codes[index];
            String business = businessLines[index];
            boolean isActive = isActives[index];

            if(isValidCode(code) && isValidBusiness(business) && isActive){
                pairs.add(List.of(code,business));
            }
        }

        Collections.sort(pairs,(p1,p2)->{
            if(priority.get(p1.get(1)) != priority.get(p2.get(1)))
                return priority.get(p1.get(1)) - priority.get(p2.get(1));
            
            return p1.get(0).compareTo(p2.get(0));
        });

        return pairs.stream().map(pair -> pair.get(0)).toList();
    }

    private boolean isValidCode(String code){
        if(code.length()==0)return false;
        for(char ch: code.toCharArray()){
            if(!Character.isLetter(ch) && !Character.isDigit(ch) && ch!='_')
                return false;
        }

        return true;
    }

    private boolean isValidBusiness(String business){
        return priority.containsKey(business);
    }
}