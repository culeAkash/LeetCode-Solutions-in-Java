import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    TreeNode node; 
    int num; 
    Pair(TreeNode node, int num) {
        this.num = num; 
        this.node = node; 
    }
}
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Pair> st = new Stack<Pair>(); 
        st.push(new Pair(root, 1)); 
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while(!st.isEmpty()){
            Pair top= st.pop();
            if(top.num==1){
                pre.add(top.node.val);
                top.num++;
                st.push(top);

                if(top.node.left!=null){
                    st.push(new Pair(top.node.left, 1));
                }
            }
            else if(top.num==2){
                in.add(top.node.val);
                top.num++;
                st.push(top);

                if(top.node.right!=null){
                    st.push(new Pair(top.node.right, 1));
                }
            }
            else{
                post.add(top.node.val);
            }

        }

    }
}

