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
// class Solution {
//     int diam;
//     int height;
    

//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null) {
//             return 0;

//         } 

//          int ldiam = diam(root.left);
//          int  rdiam = diam(root.right);
//          int  lheight= height(root.left);
//          int rheight= height(root.left);

//           int selfdiam = 1 + lheight + rheight; 

//         return diameterOfBinaryTree(ldiam, rdiam, selfdiam);
       

        
//     }
// }

class Solution {

    int diam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diam;
    }

    public  int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        
        diam = Math.max(diam, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}