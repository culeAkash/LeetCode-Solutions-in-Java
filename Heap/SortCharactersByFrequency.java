class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(Character key: map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        
        String res = "";
        while(!pq.isEmpty()){
            int count = pq.peek().count;
            while(count>0){
                res += pq.peek().ch;
                count--;
            }
            pq.poll();
        }
        return res;
    }
}

class Pair{
    char ch;
    int count;
    
    public Pair(char c,int co){
        ch = c;
        count = co;
    }
}

class Comp implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        return p2.count - p1.count;
    }
}