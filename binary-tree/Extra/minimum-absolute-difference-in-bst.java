// https://leetcode.com/problems/minimum-absolute-difference-in-bst/

**NOTE: If you are thinking of changing references of any variable in recursion, that is absolutely wrong, the moment you return back to the previous call,
it will take the original stack reference, through which it was called initially. 
So, always make sure to change the content placed at that reference and not to change the reference i.e make sure to use the same reference.**

-----------------------------------------------------------------------------------------------------------------------------------------------------------

// Using prev as TreeNode in parameter :-
/*
    Using prev as TreeNode in parameter and changing the content of the TreeNode and not the reference.
    If you would have thought to change the reference then this TreeNode would also not work like Integer in recursive call did not work,
    since we are passing it in recursive call parameter.

    Don't use prev of type Integer **in the recursive call**, since Wrapper class are immutable, and once you change the content it's reference gets changed
    and it starts pointing to the new location, and when you return back to previous call, it's still pointing the original stack reference by which it was called.
*/

```
class Solution {
    
    public int getMinimumDifference(TreeNode root) {
        TreeNode prev = new TreeNode(-1); // Since it's a BST, so keep a node prev = -1
        return getMinimumDifference_Util(root, prev);
    }
    
    // The idea is at every level, compare your minAbsDiffSoFar with (root.val(curr) - prev) Why ?
    // Because it is sorted so min difference between any two nodes can be with the very next node to me
    // And make sure to do it in inOrder since inOrder is sorted in BST
    
    public static int getMinimumDifference_Util(TreeNode root, TreeNode prev) {
        if(root == null) return Integer.MAX_VALUE;
        
        int minAbsDiff = getMinimumDifference_Util(root.left, prev); // Left se ab tak ka minAbsDiff
        if(prev.val != -1) minAbsDiff = Math.min(minAbsDiff, root.val - prev.val); // // Find diff bet you and your prev
        prev.val = root.val; // Mere right node k liye mai unki prev houngi
        
        // Compare left se minAbsDiff aaega ya mai banaungi ya right se aaega
        return Math.min(minAbsDiff, getMinimumDifference_Util(root.right, prev)); 
    }
    
}
```

----------------------------------------------------------------------------------------------------------------------------
// Without using global variable, using prev array and passing in parameter

```
class Solution {
    public int getMinimumDifference(TreeNode root) {
        int[] prev = new int[1];
        prev[0] = -1;
        return getMinimumDifference_Util(root, prev);
    }
    
    public static int getMinimumDifference_Util(TreeNode root, int[] prev) {
        if(root == null) return Integer.MAX_VALUE;
        
        int minAbsDiff = getMinimumDifference_Util(root.left, prev);
        if(prev[0] != -1) minAbsDiff = Math.min(minAbsDiff, root.val - prev[0]);
        prev[0] = root.val;
        return Math.min(minAbsDiff, getMinimumDifference_Util(root.right, prev));
    }
}
```

----------------------------------------------------------------------------------------------------------------------------------

// Using global variable :- 
/*
    Using global variable of prev of type Integer is working here because each time we change the value of prev it creates another reference like of String
    and starts pointing to the new reference, so we get the new data. 
    Here there's no concept of returning back in stack reference for prev, since we are not passing it in recursion, so it works well here.
    **Both String and Wrapper class is immutable type.**
*/

```
class Solution {
    
    public int minAbsDiff = Integer.MAX_VALUE;
    public Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        getMinimumDifference_Util(root);
        return minAbsDiff;
    }
    
    public void getMinimumDifference_Util(TreeNode root) {
        if(root == null) return;
        
        getMinimumDifference_Util(root.left);
        if(prev != null) minAbsDiff = Math.min(minAbsDiff, root.val - prev);
        prev = root.val;
        getMinimumDifference_Util(root.right);
    }
}
```

---------------------------------------------------------------------------------------------------------------------------------------
