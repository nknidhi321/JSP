// https://www.hackerrank.com/contests/second/challenges/next-greater-element/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] ans = nextGreaterElement(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " " + ans[i]);
        }
    }
    
    
     //================================================================
     public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack < Integer > stack = new Stack < > ();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = -1;
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) ans[i] = -1;
                else ans[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return ans;
    }
    //====================================================================
    
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// https://pepcoding.com/resources/online-java-foundation/stacks-and-queues/next-greater-element-official/ojquestion
// Same code at pepcoding

import java.io.*;
import java.util.*;

public class Main {
    
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = nextGreaterElement(a);
        display(nge);
    }


    //================================================================
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack < Integer > stack = new Stack < > ();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = -1;
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) ans[i] = -1;
                else ans[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return ans;
    }
    //=================================================================

}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
