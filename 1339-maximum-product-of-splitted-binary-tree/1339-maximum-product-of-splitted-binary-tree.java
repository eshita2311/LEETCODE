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
    private long maxProduct;
    private int rootSum = -1;

    public int maxProduct(TreeNode root) {
        maxProduct = Long.MIN_VALUE;
        sumSubTree(root);
        this.rootSum = root.val;
        dfs(root);
        
        return (int) (this.maxProduct % 1000000007);
    }

    private void dfs(TreeNode node){
        if(node == null) return;

        this.maxProduct = Math.max(maxProduct, (long) node.val * (this.rootSum - node.val));
        dfs(node.left);
        dfs(node.right);
    }

    private int sumSubTree(TreeNode node){
        if(node == null) return 0;

        node.val += sumSubTree(node.left) + sumSubTree(node.right);
        return node.val;
    }
}