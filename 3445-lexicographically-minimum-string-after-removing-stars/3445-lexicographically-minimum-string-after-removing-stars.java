class Solution {
    public String clearStars(String s) {
        // StringBuilder res = new StringBuilder(s);
        List<Integer> idxes = new ArrayList<>(); 
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->{
            if(p1.ch==p2.ch){
                return p2.index - p1.index;
            }else{
                return p1.ch - p2.ch;
            }
        });
        int index = 0;
        for(char ch : s.toCharArray()){
            if(ch!='*'){
                pq.offer(new Pair(ch,index));
            }else{
                idxes.add(pq.poll().index);
            }
            index++;
        }

        Collections.sort(idxes);
        int idx = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*')continue;
            if(idx<idxes.size() && i==idxes.get(idx)){
                idx++;
                continue;
            }else{
                res.append(s.charAt(i));
            }
        }

        return res.toString();

    }
}

class Pair{
    char ch;
    int index;

    public Pair(char ch,int index){
        this.ch = ch;
        this.index = index;
    }
}