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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<Integer>();
        helper(root,ans);
        return ans;
    }
    
    public void helper(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right,ans);
    }
}

//Iterative Solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<Integer>();
        
        if(root==null){
            return ans;
        }
        // List<Integer> ds= new ArrayList<>(); 
        Stack<TreeNode> st= new Stack<>();
        TreeNode curr= root;
        while(!st.isEmpty() || curr!=null){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
            curr=st.pop();
            ans.add(curr.val);
            curr=curr.right;
            }
        }
        return ans;
        
    }
}