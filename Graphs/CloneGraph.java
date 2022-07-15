/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Node[] vis = new Node[101];
        
        Node copy = new Node(node.val);
        dfs(copy,node,vis);
        return copy;
    }
    
    public void dfs(Node copy,Node node,Node[] vis){
        vis[copy.val] = copy;
        
        for(Node it:node.neighbors){
            if(vis[it.val]==null){
                Node newNode = new Node(it.val);
                copy.neighbors.add(newNode);
                dfs(newNode,it,vis);
            }
            else{
                copy.neighbors.add(vis[it.val]);
            }
        }
    }
}