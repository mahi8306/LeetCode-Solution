class Solution {

    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder,
                          int left, int right) {

        if (left > right) {
            return null;
        }

       
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        
        int index = left;

        while (inorder[index] != rootValue) {
            index++;
        }

        
        root.right = build(inorder, postorder, index + 1, right);

        
        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }
}