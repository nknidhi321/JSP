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
        
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                ans[i] = -1;
                stack.push(arr[i]);
            }
            else {
                while(!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) ans[i] = -1;
                else ans[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " " + ans[i]);
        }
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
