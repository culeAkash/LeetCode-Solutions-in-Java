class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        String res = s;
        q.offer(s);
        vis.add(s);
        int N = s.length();

        while(!q.isEmpty()){
            String cur = q.poll();

            if(cur.compareTo(res) < 0){
                res = cur;
            }

            // first alternative
            StringBuilder sb = new StringBuilder(cur);
            for (int i = 1; i < sb.length(); i += 2)
                sb.setCharAt(i, (char) ((sb.charAt(i) - '0' + a) % 10 + '0'));
            String added = sb.toString();
            if (vis.add(added)) q.offer(added);

            // Second alternative
            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.    length() - b);
            if (vis.add(rotated)) q.offer(rotated);
            
        }
        return res;
    }
}