// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-binary-strings-official/ojquestion
// Can be done using 2 pts. also

// consecutive 0's not allowed

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] dp0 = new int[n + 1];
    int[] dp1 = new int[n + 1];
    
    dp0[1] = dp1[1] = 1;
    
    for(int i = 2; i <= n; i++) {
        dp0[i] = dp1[i - 1];
        dp1[i] = dp0[i - 1] + dp1[i - 1];
    }
    
    System.out.println(dp0[dp0.length - 1] + dp1[dp1.length - 1]);
 }

}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1/#
// Consecutive 1's not allowed

class Solution {
    
    public static long mod = (long)1e9 + 7; 
    
    long countStrings(int n) {
        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];
        
        dp0[1] = dp1[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp0[i] = dp1[i - 1];
            dp1[i] = (dp0[i - 1] + dp1[i - 1]) % mod;
        }
        return (dp0[dp0.length - 1] + dp1[dp1.length - 1]) % mod;
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
