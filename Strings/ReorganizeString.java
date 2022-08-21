class Solution {
    public String reorganizeString(String str) {
     int[] freq = new int[26];
		
		for(int i=0;i<str.length();i++){
		    freq[str.charAt(i)-'a']++;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
		
		for(int i=0;i<26;i++){
		    if(freq[i]!=0)
		        pq.offer(new Pair((char)(i+'a'),freq[i]));
		}
		
		StringBuilder res = new StringBuilder();
		
		while(pq.size()>1){
		    Pair p1 = pq.poll();
		    Pair p2 = pq.poll();
		    
		    res.append(p1.ch);
		    res.append(p2.ch);
		    
		    int c1 = p1.count-1;
		    int c2 = p2.count-1;
		    
		    if(c1>0)
		        pq.offer(new Pair(p1.ch,c1));
		        
		      if(c2>0)
		        pq.offer(new Pair(p2.ch,c2));
		    
		}
		
		if(pq.size()==1){
		    Pair p = pq.poll();
		    
		    if(p.count>1)
		        return "";
		    
		    res.append(p.ch);
		}
		
		return res.toString();
	}
}

class Pair{
    char ch;
    int count;
    
    public Pair(char ch,int v){
        this.ch = ch;
        count = v;
    }
}

class Comp implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        return p2.count-p1.count;
    }
}