//https://pepcoding.com/resources/online-java-foundation/generic-tree/node-with-maximum-subtree-sum-official/ojquestion

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
  
  //===============================================================================================

  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$==========IMPORTANT============$$$$$$$$$$$$$$$$$$$$$$$$$ 
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  
  public static int maxSum = Integer.MIN_VALUE;
  public static Node maxSumNode = null;
  
  public static int returnSum_And_CalculateMaxSumSubtree(Node root) {
      int sum = root.data;
      for(Node child : root.children) {
          sum += returnSum_And_CalculateMaxSumSubtree(child);
      }
      if(sum > maxSum) {
          maxSum = sum;
          maxSumNode = root;
      }
      return sum;
  }
  
  //================================================================================================
	
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$==========IMPORTANT============$$$$$$$$$$$$$$$$$$$$$$$$$ 
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
  
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$==========IMPORTANT============$$$$$$$$$$$$$$$$$$$$$$$$$ 
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  
  public static class Triplet {
      int maxSumTree;
      Node maxSumTreeNode;
      int sumOfSubtree;
      
      public Triplet(int maxSumTree, Node maxSumTreeNode, int sumOfSubtree) {
          this.maxSumTree = maxSumTree;
          this.maxSumTreeNode = maxSumTreeNode;
          this.sumOfSubtree = sumOfSubtree;
      }
  }
  
  public static Triplet returnObject_MaxSumSubtree(Node root) {
      int sumOfTree = root.data;
      
      int maxSumTree = Integer.MIN_VALUE;
      Node maxSumTreeNode = null;
      int sumOfSubtree = 0;
      
      for(Node child : root.children) {
          Triplet smallAns = returnObject_MaxSumSubtree(child);
          sumOfTree += smallAns.sumOfSubtree;
          if(smallAns.maxSumTree > maxSumTree) {
              maxSumTree = smallAns.maxSumTree;
              maxSumTreeNode = smallAns.maxSumTreeNode;
          }
        }
        
        if(sumOfTree > maxSumTree){
             maxSumTree = sumOfTree;
             maxSumTreeNode = root;
        }
      
       //Note : sumOfTree will be the sumOfSubtree for the parent node,
       //hence pass sumOfTree as the 3rd argument not sumOfSubtree
       return new Triplet(maxSumTree, maxSumTreeNode, sumOfTree);
  }
  
  //=================================================================================================
 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    Node root = construct(arr);
    
	//returnSum_And_CalculateMaxSumSubtree(root);
    //System.out.println(maxSumNode.data + "@" + maxSum);
    
    Triplet triplet = returnObject_MaxSumSubtree(root);
    System.out.println(triplet.maxSumTreeNode.data + "@" + triplet.maxSumTree);
  
  }
	
}
