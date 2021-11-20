//https://www.pepcoding.com/resources/online-java-foundation/generic-tree/kth-largest-element-generic-tree-official/ojquestion

//Using Travel and Change Strategy
//TC: O(N)

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

  
  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data > data){
      if(node.data < ceil){
        ceil = node.data;
      }
    }

    if(node.data < data){
      if(node.data > floor){
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }


  //=============================================================================================================================================
  //intuition : Floor deta h maximum value against a data, so repeat it for k times to get kth largest 
  
  public static int kthLargest(Node node, int k) {
    floor = Integer.MIN_VALUE;
    int data = Integer.MAX_VALUE;
    
    for(int i = 0; i < k; i++) {
        
        //1st iteration me data(Integer.MAX_VALUE) se Just Chota(matlab tree ka maximum value) floor me set ho jaaega
        //2nd iteration me tree k maximum value se Just chota floor me set ho jaaega
        //And so on..
        ceilAndFloor(node, data);
        data = floor;               //Prepare data for the next iteration
        floor = Integer.MIN_VALUE;  //Now set it to Integer.MIN_VALUE to find the largest among the smaller(against the data) for next iteration
    }
    
    //NOTE: Answer gets stored in data and floor is set to Integer.MIN_VALUE at each iteration
    //So make sure to return data and not floor
    return data; 
  }
  //==============================================================================================================================================


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int kthLargest = kthLargest(root, k);
    System.out.println(kthLargest);
  }

}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//Using PriorityQueue 
//TC: O(NlogK) 

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

  
  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data > data){
      if(node.data < ceil){
        ceil = node.data;
      }
    }

    if(node.data < data){
      if(node.data > floor){
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }

	
  //===================================================================================================
  public static int kthLargest(Node node, int k){
    // write your code here
    PriorityQueue<Integer> pqueue = new PriorityQueue<>();
    kthLargest_Util(node, k, pqueue);
    return pqueue.poll();
  }
  
  public static void kthLargest_Util(Node node, int k, PriorityQueue<Integer> pqueue){
      pqueue.add(node.data);
      if(pqueue.size() > k) pqueue.poll();
      
      for(Node child : node.children){
          kthLargest_Util(child, k, pqueue);
      }
  }
  //==================================================================================================

	
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int kthLargest = kthLargest(root, k);
    System.out.println(kthLargest);
  }

}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
