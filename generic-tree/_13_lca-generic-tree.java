//https://pepcoding.com/resources/online-java-foundation/generic-tree/lca-generic-tree-official/ojquestion

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/1301160/Java-or-Solution-based-on-NodeToPath
Solution
========

Get the path from p to root and q to root, store them in list

The idea is, the value of all the nodes, upto the LCA from the root will be the same from the root till the LCA.
Check this in path1 (for p) and path2 (for q), values will be same upto a certain position from root to LCA. (From right to left in the list, 
since the p or q node is added first in the list and then the parent nodes above them).
So, keep a while loop iterating from the right of the list and the moment you find different value iterating from the root (end of the list), 
the prev at that point will contain your LCA TreeNode, since prev contains the previous TreeNode.
*/


import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

//=========================================================================================

  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$==========IMPORTANT============$$$$$$$$$$$$$$$$$$$$$$$$$ 
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$	
  public static int lca(Node node, int d1, int d2) {
    // write your code here
    ArrayList<Integer> d1path = nodeToRootPath(node, d1);
    ArrayList<Integer> d2path = nodeToRootPath(node, d2);
    
    int i = d1path.size() - 1;
    int j = d2path.size() - 1;
    int prevLCA = -1; 
    while(i >= 0 && j >= 0){
        if(d1path.get(i) != d2path.get(j)) break;
        prevLCA = d1path.get(i);
        i--; j--;
    }
    return prevLCA;
  }
//=========================================================================================
 
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int d1 = Integer.parseInt(br.readLine());
    int d2 = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int lca = lca(root, d1, d2);
    System.out.println(lca);
    // display(root);
  }

}
