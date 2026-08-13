class Solution {
    public boolean isSameTree(TreeNode root, TreeNode SubRoot) {

        if (root == null && SubRoot == null) {
            return true;
        }

        if (root == null || SubRoot == null || root.val != SubRoot.val) {
            return false;
        }

        return isSameTree(root.left, SubRoot.left)
            && isSameTree(root.right, SubRoot.right);
    }
}