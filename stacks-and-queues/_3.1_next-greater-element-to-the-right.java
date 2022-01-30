// https://pepcoding.com/resources/online-java-foundation/stacks-and-queues/next-greater-element-official/ojquestion
// https://www.hackerrank.com/contests/second/challenges/next-greater-element/problem

// Brute force
// TC : O(N^2)

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
    
    
     //=====================================================
     public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }
    //======================================================
    
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// Using Stack 
// Iterating from right

// More intuitive
// TC : O(2N) : At max every element will be visited twice once while pushing in the stack, and again while poping from the stack

// Note : Yaha elements push karenge stack me. Why ? Because tum jis idx pe hoge tum us idx ka answer bnate chale jaaoge 

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
          
        for (int i = arr.length - 1; i >= 0; i--) {                     // Start from right end, kuki answer bnate waqt easy hoga
            if (stack.isEmpty()) {
                ans[i] = -1;
            } 
            else {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {     // Agar stack k top pe koi element humse chota exist krta hai toh wo hamara answer kvi nai bn sakta
                    stack.pop();                                        // Kuki next greater element find karna tha so pop()
                }
                if (stack.isEmpty()) ans[i] = -1;       // Agar pop krte krte stack empty ho gaya mtlb mera next greater -1 hoga   
                else ans[i] = stack.peek();             // Else agar ab v stack k top pe elements bacha hai then stack ka top mera next greater bnega
            }
            stack.push(arr[i]);                         // Push yourself(element) because tum apne se piche walo ka answer bn saktey ho   
        }
        return ans;
    }
    //====================================================================
    
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// Using Stack 
// Iterating from left

// Less intuitive
// TC : O(2N) : At max every element will be visited twice once while pushing in the stack, and again while poping from the stack

// Note : Yaha idx push hoga stack me. Why ? Because tum jis idx pe tum uska answer nahi bnawa rahe ho yaha, tum jo elements pop krawaoge tum uska answers bnaoge yaha
// Suppose element he push kiya tha tumne, toh ab element 2 ka kya position tha tumko wo dhoondhna parega mtlb O(N) ka kharcha and then tum answer daal paaoge us idx pe,
// So, better way would be idx he push kar do stack me.

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
        Arrays.fill(ans, -1);
        Stack < Integer > stack = new Stack < > ();
        
        
        for (int i = 0; i < n; i++) {                                   // If we iterate from left
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {    // Jo v mere se chote elements hai stack me, mai uska answer bn sakti hu
                ans[stack.pop()] = arr[i];                              // So answer bn jaao and us idx ko pop kar do, kuki ab us idx ka answer bn chuka hai
            }
            stack.push(i);                                              // Push yousrself(idx) kuki uska answer bn na baaki hai avi 
        }
        return ans;
    }
    //=================================================================
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
