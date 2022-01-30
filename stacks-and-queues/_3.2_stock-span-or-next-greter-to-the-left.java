// https://pepcoding.com/resources/online-java-foundation/stacks-and-queues/stock-span-official/ojquestion

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

        int[] span = nextGreaterElementToTheLeft(a);
        display(span);
    }

  
    //==================================================================================================================================================
    public static int[] nextGreaterElementToTheLeft(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();                             // NOTE : Idx store karna hoga stack me kuki difference(span) nikalana hai
        
        for(int i = 0; i < n; i++) {                                      // Iterating from left
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {       // Mere se chota jo v tha stack me sabko pop krwa do
                stack.pop();                                              // Kuki wo mera answer kvi nai bn sakta hai
            }
            // Ab agar stack me elements bache hai then top pe jo v para hoga wo arr[i] se bada he hoga
            // So, apna answer bna lo that is span(diff of idx's)
            if(!stack.isEmpty()) ans[i] = i - stack.peek();               // Note : Yaha pop mat krwana kuki wo idx kisi aur ka v asnwer bn sakta hai 
            
            // Else agar stack empty ho gaya then mera next greater to left, 0 se pehle ek idx mtlb -1 se span niklega
            else ans[i] = i - (-1);
            
            stack.push(i);                                                // Push youself(idx), kuki tum v kisi ka answer bn saktey ho
        }
        return ans;
    }
    //=================================================================================================================================================

}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
