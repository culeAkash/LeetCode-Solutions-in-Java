class Solution {
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root==null)
        return root;


        if(root.val==val){
            //Three cases

            // 1. if zero children return null
            //2. of one child return that child
            //3. if two children get the minimum from right side and replae value and then delete from right side

            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            TreeNode temp= root.right;
            int min= temp.val;
            while(temp.left!=null){
                temp=temp.left;
                min=temp.val;
            }
            root.val=min;
            root.right= deleteNode(root.right, min);
            return root;
        }

        //If the val is greater than the root value it search on the right side

        if(root.val<val){
            TreeNode rightAns= deleteNode(root.right, val);
            root.right= rightAns;
            rightAns=root;
            return rightAns;
        }

        else{
            TreeNode leftAns= deleteNode(root.left, val);
            root.left= leftAns;
            leftAns=root;
            return leftAns;
        }
    }
}