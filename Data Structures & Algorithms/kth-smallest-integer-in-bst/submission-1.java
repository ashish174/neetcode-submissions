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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = findKthSmallest(root, new wrapperForInt(k));  
        if(node!=null){
            return node.val;
        } else {
            return 0;
        }    
    }

    private TreeNode findKthSmallest(TreeNode root, wrapperForInt intWrapper) {
        if(root==null){
            return null;
        }
        TreeNode lfind = findKthSmallest(root.left, intWrapper);
        intWrapper.k = intWrapper.k - 1;
        if(intWrapper.k==0){
            return root;
        }
        TreeNode rfind = findKthSmallest(root.right, intWrapper);
        if(lfind!=null){
            return lfind;
        }
        if(rfind!=null){
            return rfind;
        }
        return null;
    }

    class wrapperForInt{
        int k;

        public wrapperForInt(int k){
            this.k = k;
        }
    }
}
