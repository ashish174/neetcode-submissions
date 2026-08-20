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

    public boolean isValidBST(TreeNode root) {
        TreeNodeWrapper prevNodeWrapper = new TreeNodeWrapper();
        return checkIfValidBST(prevNodeWrapper, root);   
    }

    private boolean checkIfValidBST(TreeNodeWrapper prevNodeWrapper, TreeNode root){
        if(root==null){
            return true;
        }
        if(!checkIfValidBST(prevNodeWrapper, root.left)){
            return false;
        }
        if(prevNodeWrapper.prev!=null && prevNodeWrapper.prev.val >= root.val) {
            return false;
        }
        prevNodeWrapper.prev = root;
        if(!checkIfValidBST(prevNodeWrapper, root.right)){
            return false;
        }
        return true;
    }

    class TreeNodeWrapper{
        TreeNode prev;
    }

    

    // public boolean isValidBST(TreeNode root) {
    //     if(root==null) {
    //         return true;
    //     }
    //     return checkCurrentNode(root) && isValidBST(root.left) && isValidBST(root.right);
    // }

    // boolean checkCurrentNode(TreeNode node){
    //     boolean leftDependency = true;
    //     boolean rightDependency = true;
    //     if(node.left!=null){
    //         leftDependency = findMax(node.left).val < node.val;
    //     }
    //     if(node.right!=null){
    //         rightDependency = findMin(node.right).val > node.val;
    //     }

    //     return  leftDependency && rightDependency;

    // }

    // TreeNode findMin(TreeNode root){
    //     if(root==null){
    //         return root;
    //     }
    //     while(root.left!=null){
    //         root = root.left;
    //     }
    //     return root;
    // }

    // TreeNode findMax(TreeNode root){
    //     if(root==null){
    //         return root;
    //     }
    //     while(root.right!=null){
    //         root = root.right;
    //     }
    //     return root;
    // }


}
