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
class CBTInserter {

    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
    }
    
    public int insert(int val) {
        Queue<TreeNode> pN = new LinkedList<>();

        TreeNode parent = null;
        pN.offer(this.root);

        
        while(!pN.isEmpty()){
            int size = pN.size();

            boolean flag = false;
            for(int i=0;i<size;i++){
                TreeNode present = pN.poll();

                if(i==0){
                    parent = present;
                }
                

                if(present.left!=null && present.right==null){
                    // System.out.println("Inside");
                    present.right = new TreeNode(val);
                    return present.val;
                }

                if(present.left==null && present.right==null){
                    if(flag==true){
                        present.left = new TreeNode(val);
                    return present.val;
                    }
                }

                if(present.left!=null){
                    pN.offer(present.left);
                    flag = true;
                }

                if(present.right!=null){
                    pN.offer(present.right);
                    flag = true;
                }

                
            }
            }
            parent.left = new TreeNode(val);
            return parent.val;
        
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */