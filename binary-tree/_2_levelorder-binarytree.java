//https://pepcoding.com/resources/online-java-foundation/binary-tree/levelorder-binarytree-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

//=====================================================================================================================================
//Keeping 2 while loops for level change
  
  public static void levelOrder_01(Node root) {
    // write your code here
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    
    while(!queue.isEmpty()){
        int size = queue.size();
        while(size-- > 0){
            Node currNode = queue.poll();
            System.out.print(currNode.data + " ");
            if(currNode.left != null) queue.add(currNode.left);
            if(currNode.right != null) queue.add(currNode.right);
        }
        System.out.println();
    }
    
  } 
  
//====================================================================================================================================  
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$==========IMPORTANT============$$$$$$$$$$$$$$$$$$$$$$$$$ 
//$$$$$$$$$$$$$$$===============================$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
  
//Adding Delimeter null for level change
  
  public static void levelOrder_02(Node root) {
    // write your code here
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    
    while(!queue.isEmpty()){
        //Step 2) In the previous loop iteration, you had last node of the tree(4) and the null value,
        //then node gets poped out in the prvious iteration and gets printed in step 1 and you are left with only last null value,
        //Step 3) In the current loop iteration you pop out the null value 
        Node currNode = queue.poll();
        if(currNode == null){
            
            //Step 4) You print the blank line
            System.out.println();
            
            //Step 5)
            //Now, If you do not check the condition queue.size() > 0, then 
            //Again you will end up adding a null in your queue, Current state -> queue : null 
            //and you will land up with infinite while loop
            //So, null will pop out and keep adding again, if you do not check queue.size() > 0 before adding a null value
            if(queue.size() > 0) queue.add(null);
        }
        else{
            //Assume Current state -> queue : 4, null 
            //Step 1) Print's 4, no child of 4, so nothing gets added in the queue after that 4, null
            System.out.print(currNode.data + " ");
            if(currNode.left != null) queue.add(currNode.left);
            if(currNode.right != null) queue.add(currNode.right);
        }
    }
    
  }
  
//==========================================================================================================================================

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
  //  levelOrder_01(root);
    levelOrder_02(root);
  }

}
