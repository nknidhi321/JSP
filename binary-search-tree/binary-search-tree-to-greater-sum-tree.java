// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

// In BST, inorder is sorted in asc order, so travel reverse of inorder to get in desc order
// Traverse in reverse inOrder and keep on summing up the nodes val
```
class Solution {
    
    public TreeNode bstToGst(TreeNode root) {
        TreeNode sum = new TreeNode(0, null, null);
        return bstToGst_Util(root, sum);
    }
    
    public TreeNode bstToGst_Util(TreeNode root, TreeNode sum) {
        if(root == null) return null;
        
        bstToGst_Util(root.right, sum);
        root.val = sum.val = sum.val + root.val;
        bstToGst_Util(root.left, sum);
        return root;
    }
    
}
```
