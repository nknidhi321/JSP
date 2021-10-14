//https://pepcoding.com/resources/online-java-foundation/generic-tree/distance-between-nodes-official/ojquestion

/*
NOTE: 
-> Distance between 2 nodes will be the Number of nodes from d1 node to LCA  +  Number of nodes from d2 node to LCA
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

  public static int lca(Node node, int d1, int d2) {
    ArrayList<Integer> p1 = nodeToRootPath(node, d1);
    ArrayList<Integer> p2 = nodeToRootPath(node, d2);

    int i = p1.size() - 1;
    int j = p2.size() - 1;

    while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
      i--;
      j--;
    }

    return p1.get(i + 1);
  }

//=========================================================================================

  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$==========IMPORTANT============$$$$$$$$$$$$$$$$$$$$$$$$$ 
  //$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

  public static int distanceBetweenNodes(Node node, int d1, int d2){
    // write your code here
    ArrayList<Integer> d1path = nodeToRootPath(node, d1);
    ArrayList<Integer> d2path = nodeToRootPath(node, d2);
    
    int i = d1path.size() - 1;
    int j = d2path.size() - 1;
    while(i >= 0 && j >= 0){
        if(d1path.get(i) != d2path.get(j)) break;
        i--; j--;
    }
    return (i + 1) + (j + 1);
    
  }

//====================================================================================

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
    int dist = distanceBetweenNodes(root, d1, d2);
    System.out.println(dist);
    // display(root);
  }

}
