// https://leetcode.com/problems/range-sum-of-bst/

class Solution {
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        
        if(low < root.val && high < root.val) return rangeSumBST(root.left, low, high);
        else if(low > root.val && high > root.val) return rangeSumBST(root.right, low, high);
        else { // within range
            int sum = 0;
            sum += rangeSumBST(root.left, low, high);
            sum += root.val;
            sum += rangeSumBST(root.right, low, high);
            return sum;
        }
    }
}
