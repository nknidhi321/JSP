//https://pepcoding.com/resources/online-java-foundation/binary-tree/diameter-of-binary-tree-official/ojquestion
//https://leetcode.com/problems/diameter-of-binary-tree/discuss/1534470/Java-or-4-approaches-or-Do-checkout

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

        Stack < Pair > st = new Stack < > ();
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


  
    //=======================================================================================================
    // TC : O(N^2)
    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static int get_Height_And_return_Diameter_01(Node root) {
        // write your code here
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDia = get_Height_And_return_Diameter_01(root.left);
        int rightDia = get_Height_And_return_Diameter_01(root.right);

        return Math.max(Math.max(leftDia, rightDia), leftHeight + rightHeight + 2);
    }

    //=======================================================================================================

    // Make maxDia as static, setting 0 when root == null
    // TC : O(N), but since it is static do not use
    public static int maxDia = 0;

    public static int return_Height_And_calculateDiameter_02(Node root) {
        // write your code here
        if (root == null) return -1; //returning height in terms of edge

        int leftHeight = return_Height_And_calculateDiameter_02(root.left);
        int rightHeight = return_Height_And_calculateDiameter_02(root.right);

        maxDia = Math.max(maxDia, leftHeight + rightHeight + 2);
        return Math.max(leftHeight, rightHeight) + 1;
    }

  //=======================================================================================================

  // Consider root is null and set the default value
    public static class DiaPair {
        int height = -1; // -1 because height is in terms of edges
        int maxDiameter = 0;

        DiaPair(int height, int maxDiameter) {
            this.height = height;
            this.maxDiameter = maxDiameter;
        }
    }

    public static DiaPair return_DiaPair_And_calculateDiameter_03(Node root) {
        if (root == null) return new DiaPair(-1, 0);

        DiaPair l = return_DiaPair_And_calculateDiameter_03(root.left);
        DiaPair r = return_DiaPair_And_calculateDiameter_03(root.right);

        int currPairHeight = Math.max(l.height, r.height) + 1;
        int currPairMaxDiameter = Math.max(Math.max(l.maxDiameter, r.maxDiameter), l.height + r.height + 2);
        DiaPair currPair = new DiaPair(currPairHeight, currPairMaxDiameter);
        return currPair;
    }

    //========================================================================================================
  
    // Make array of maxDia, works just like static, but destroys when the function ends, but static destoys when main ends 
    public static int return_Height_And_PassDiameter_04(Node root, int[] maxDia) {
        if (root == null) return -1;

        int leftHeight = return_Height_And_PassDiameter_04(root.left, maxDia);
        int rightHeight = return_Height_And_PassDiameter_04(root.right, maxDia);

        maxDia[0] = Math.max(maxDia[0], leftHeight + rightHeight + 2);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    //========================================================================================================

    
    
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

        //Type1
        // int diameter = get_Height_And_return_Diameter_01(root);
        // System.out.println(diameter);

        //Type2
        return_Height_And_calculateDiameter_02(root);
        System.out.println(maxDia);

        //Type3
        // DiaPair ans = return_DiaPair_And_calculateDiameter_03(root);
        // System.out.println(ans.maxDiameter);

        //Type4
        // int[] maxDia = new int[1];
        // return_Height_And_PassDiameter_04(root, maxDia);
        // System.out.println(maxDia[0]);
    }

}
