/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse down the tree while root is not null
        while (root != null) {
            // If both p and q are smaller than root, go to the left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } 
            // If both p and q are greater than root, go to the right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } 
            // Otherwise, we have found the split point (LCA)
            else {
                return root;
            }
        }
        return null;
    }
}