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
