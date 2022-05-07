// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling1-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[] dp = new Integer[n + 1];
        System.out.println(tiling(n, dp));
    }
    
    public static int tiling(int n, Integer[] dp){
        if(n == 0 || n == 1) return dp[n] = 1;
        
        if(dp[n] != null) return dp[n];
    
        return dp[n] = tiling(n - 1, dp) + tiling(n - 2, dp);
    }
}

//-------------------------------------------------------------------------------
// https://practice.geeksforgeeks.org/problems/ways-to-tile-a-floor5836/1/


class Solution {

    public static long mod = (long)1e9 + 7;

    static Long numberOfWays(int n) {
        Long[] dp = new Long[n + 1];
        return tiling(n, dp);
    }
    
    public static long tiling(int n, Long[] dp) {
        if(n == 0 || n == 1) return dp[n] = (long)1;
        
        if(dp[n] != null) return dp[n];
    
        return dp[n] = (tiling(n - 1, dp) + tiling(n - 2, dp)) % mod;
    }
}
