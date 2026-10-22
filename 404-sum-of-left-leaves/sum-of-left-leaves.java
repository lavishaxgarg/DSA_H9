class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        
        // Check if the left child is a leaf node
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        
        // Traverse the right subtree normally
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}