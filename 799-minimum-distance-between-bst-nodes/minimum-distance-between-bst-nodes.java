class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);

        int ans1 = Integer.MAX_VALUE;

        for (int i = 1; i < ans.size(); i++) {
            ans1 = Math.min(ans1, ans.get(i) - ans.get(i - 1));
        }

        return ans1;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}