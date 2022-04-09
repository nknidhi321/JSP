// https://leetcode.com/problems/cousins-in-binary-tree/

class Solution {
    
    int x_Parent = -1;
    int y_Parent = -1;
    int x_level = -1;
    int y_level = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        return isCousins_Util(root, x, y, 0);
    }
    
    public boolean isCousins_Util(TreeNode root, int x, int y, int level) {
        if(root == null) return false;
        
        if(root.left != null && root.left.val == x) {
            x_Parent = root.val;
            x_level = level;
        }
        else if(root.left != null && root.left.val == y) {
            y_Parent = root.val;
            y_level = level;
        }
        
        if(root.right != null && root.right.val == x) {
            x_Parent = root.val;
            x_level = level;
        }
        else if(root.right != null && root.right.val == y) {
            y_Parent = root.val;
            y_level = level;
        }
        
        if((x_level != -1 && y_level != -1 && x_level == y_level) &&
           (x_Parent != -1 && y_Parent != -1 && x_Parent != y_Parent)) return true;
        
        return isCousins_Util(root.left, x, y, level + 1) || isCousins_Util(root.right, x, y, level + 1);
    }
    
}
