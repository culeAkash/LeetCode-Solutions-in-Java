/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if(root==null)
            return res;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while(!st1.empty()){
            Node top = st1.pop();

            st2.push(top);

            for(Node child : top.children){
                st1.push(child);
            }
        }

        while(!st2.empty()){
            res.add(st2.pop().val);
        }

        return res;
    }
}