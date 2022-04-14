// https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-two-arrays2408/1/#
// Rajneesh

class Solution{
  
    public String calc_Sum(int a[], int n, int b[], int m) {
        String ans = "";
        int i = n - 1;
        int j = m - 1;
        int carry = 0;
        // summing
        while(i >= 0 || j >= 0 || carry != 0) {
            int sum = (i >= 0 ? a[i] : 0) + (j >= 0 ? b[j] : 0) + carry;
            ans = (sum % 10) + ans;
            carry = sum / 10;
            i--; j--;
        }

        // Removing leading 0's        
        i = 1;
        while(i < ans.length()) {
            if(ans.charAt(i - 1) == '0') i++;
            else return ans.substring(i - 1, ans.length());
        }
        return "";
    }
  
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------

// https://classroom.pepcoding.com/myClassroom/the-switch-program-4/functions-and-arrays/sum-of-two-arrays-official/ojquestion
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int[] arr1 = new int[n1];
    for(int i = 0; i < n1; i++){
        arr1[i] = sc.nextInt();
    }
    
    int n2 = sc.nextInt();
    int[] arr2 = new int[n2];
    for(int i = 0; i < n2; i++){
        arr2[i] = sc.nextInt();
    }
    
    int[] ans = new int[Math.max(n1, n2) + 1]; // +1 to accomodate the extra carry
    int carry = 0;
    int idx1 = arr1.length - 1;
    int idx2 = arr2.length - 1;
    int ansIdx = ans.length - 1; 
    
    while(ansIdx >= 0){
        int digit1 = idx1 >= 0 ? arr1[idx1--] : 0;
        int digit2 = idx2 >= 0 ? arr2[idx2--] : 0;
        int sum = digit1 + digit2 + carry;
        ans[ansIdx] = sum % 10;
        carry = sum / 10;
        ansIdx--;
    }
    
    for(int i = 0; i < ans.length; i++) {
        if(i == 0 && ans[i] == 0) continue; // Checking if the last carry from right to left was 0 then skip else print
        System.out.println(ans[i]); // Print rest of the sum  
    }
 }

}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------
