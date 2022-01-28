//Recursive Solution

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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    
    public void helper(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        
        ans.add(root.val);
        helper(root.left,ans);
        helper(root.right,ans);
        
    }
}

//Iterative Solution

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    
    public void helper(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        
        Deque<TreeNode> st= new ArrayDeque<TreeNode>();
        TreeNode curr=root;
        st.push(curr);
        while(!st.isEmpty()){
            curr=st.pop();
            ans.add(curr.val);
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
        }
        
    }
}
