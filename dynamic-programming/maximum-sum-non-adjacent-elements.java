// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/maximum-sum-non-adjacent-elements-official/ojquestion

// Similar to house robber, but here elements can be negative too
// So, If there are negative values we will not loot that house

// If elements is less than 0(negative), make it as 0 =>, so we add 0 in place of -ve values => That house will not be looted. 
// NOTE : If all elements are 0, you won't loot any house, So answer is 0

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if(nums[i] < 0) nums[i] = 0; // If elements is less than 0, make it as 0
            // NOTE : If all elements are 0, you won't loot any house, So answer is 0
        }
        Integer[] dp = new Integer[n + 1];
        System.out.println(rob_Memo(n, nums, dp));
    }
    
    public static int rob_Memo(int n, int[] nums, Integer[] dp) {
      
        // Jab house = 0 hai toh max 0 steal kar saktey ho
        // Jab house = 1 hai toh max usi ek house ko steal kar sakey ho
        if(n == 0 || n == 1) return dp[n] = (n == 0 ? 0 : nums[n - 1]);  
        
        if(dp[n] != null) return dp[n];
        
        // Max of adjacent and currHouse se steal karne ka chance tvi milega jab house >= 2 honge
        int adjacentMax = 0, currMax = 0;
        adjacentMax = rob_Memo(n - 1, nums, dp);  // Not taking curr element
        currMax = rob_Memo(n - 2, nums, dp) + nums[n - 1];  // Taking curr element
        
        // Now, take the max of the above two choices
        return dp[n] = Math.max(adjacentMax, currMax);
    }
}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
