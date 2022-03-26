// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ 

// In "BST" when you find there's diversion(one lies in left && the other in right or vice-verse) of p and q node, that is your LCA

// NOTE : LCA of binary tree cannot be found using the same algo, because there nodes are not in sorted order,
// so you cannot discard your search space like you do in binary search.

```
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
```
