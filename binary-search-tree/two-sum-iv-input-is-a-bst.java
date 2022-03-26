// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

// Using set, by finding compliment of the curr node val in the set
// Not using BST property
// TC : O(N), SC : O(N)
// The idea is, at each node search for k - root.val in the HashSet, if found return true else continue your search for left and right subtree.
// If you reach a null node, simply return false beacuse you did not find your k - root.val at any node.

```
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTargetHelper(root, set, k);
    }
    
    public static boolean findTargetHelper(TreeNode root, Set<Integer> set, int k){
        if(root == null) return false;
        
        if(findTargetHelper(root.left, set, k)) return true;
        
        if(set.contains(k - root.val)) return true;
        else set.add(root.val);
        
        if(findTargetHelper(root.right, set, k)) return true;
        
        return false;
    }
}
```

--------------------------------------------------------------------------------------

// Using two pointers
// Using sorted property of BST
// Fill your node values in list and apply two pointers algorithm.
// TC : O(2N), SC : O(N)

```
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        
        // Get nodes in sorted order in your list
        List<Integer> list = new ArrayList<>();
        getSortedNodeValues(root, list);
        
        // Now apply two pointers Algorithm
        int start = 0, end = list.size() - 1;
        while(start < end) {
            int sum = list.get(start) + list.get(end);
            if(sum < k) start++;
            else if(sum > k) end--;
            else return true; // sum == k
        }
        return false;
    }
    
    // Fill arrayList in sorted order using inOrder traversal of BST
    public static void getSortedNodeValues(TreeNode root, List<Integer> list) {
        if(root == null) return;
        
        getSortedNodeValues(root.left, list);
        list.add(root.val);
        getSortedNodeValues(root.right, list);
    }
    
}
```

----------------------------------------------------------------------------------------------------

// TC : NlogN, SC : O(1)
// Reaching to a node and calling find method for comp of nodes val

```
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        return findPairsEqualsToTarget(root, root, k);
    }
    
      // find in BST is logN
      public static boolean find(TreeNode root, int tar) {
          if(root == null) return false;

          if(tar < root.val) return find(root.left, tar);
          else if(tar > root.val) return find(root.right, tar);
          else return true;
      }

      // finding for n nodes, so TC = NlogN 
      public static boolean findPairsEqualsToTarget(TreeNode oroot, TreeNode root, int target) {
          if(root == null) return false;

          if(findPairsEqualsToTarget(oroot, root.left, target)) return true;

          int comp = target - root.val;
          // you don't have to print permutations of Pair {a, b}
          // And moving in inOrder so considering a as the smaller guy and it's comp b to be the larger guy
          if(comp > root.val) { 
              if(find(oroot, comp)) {
                 return true;
              }
          }

          if(findPairsEqualsToTarget(oroot, root.right, target)) return true;
          
          return false;
      }
    
}
```
---------------------------------------------------------------------------------------------------------------
