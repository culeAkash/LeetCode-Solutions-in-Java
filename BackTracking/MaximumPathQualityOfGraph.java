class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        int[] res = new int[1]; 
        int[] visited = new int[n]; // this is int[] and not boolean[] beacuse we can visit a node multiple times but we can add its values only ONCE
        Map<Integer, List<Neighbor>> adjMap = new HashMap<>(); // Neighbor contains the adhacent node and time
        
        // this will make sure that EVERY node has an entry in the MAP even it is present or not in the EDGE[][]
        // this is because there are few edge cases with either NO '0' node, or empty edge[][]
        for(int i = 0; i < n; i++) {
            adjMap.put(i, new ArrayList<>());
        }
        
        // make adjacency map
        for(int[] edge : edges) {
            int curr = edge[0], neighbor = edge[1], time = edge[2];
            
            adjMap.get(curr).add(new Neighbor(neighbor, time));
            adjMap.get(neighbor).add(new Neighbor(curr, time));
        }
                
        visited[0]++;
        helper(values, visited, adjMap, res, 0, maxTime, values[0]);
        
        return res[0];
    }
    
    private void helper(int[] values, int[] visited, Map<Integer, List<Neighbor>> adjMap, int[] res, int currNode, int maxTimeLeft, int currSum) {
        if(currNode == 0) { // potential answer since the path should always end at 0
            res[0] = Math.max(res[0], currSum); 
        }
        
        // if we have completely utilized the maxTime, return
        if(maxTimeLeft < 0) return;
        
        // for ALL the neighbors of currNode (DFS)
        for(Neighbor n : adjMap.get(currNode)) {
            int adjNode = n.neighbor, time = n.time;
            if(maxTimeLeft - time < 0) continue; // if we go to next node whose time surpasses the remaining maxTime, we cannot use it
            visited[adjNode]++; // mark adjNode as visited
            
            // recursion with currNode as adjNode
            // NOTE : we only need to add the values[currNode] if it is the FIRST time we are visiting it
            helper(values, visited, adjMap, res, adjNode, maxTimeLeft - time, currSum + (visited[adjNode] == 1 ? values[adjNode] : 0));
            
            // backtrack
            visited[adjNode]--;
        }
    }
}

class Neighbor {
    int neighbor;
    int time;
    
    public Neighbor(int n, int t) {
        this.neighbor = n;
        this.time = t;
    }
}