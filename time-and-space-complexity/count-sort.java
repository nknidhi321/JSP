//https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/count-sort-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

	
  //=================================================================================================================================
  public static void countSort(int[] arr, int min, int max) {
      
    // Create Frequency of size equal to range of elements
    int range = max - min + 1;
    int[] freq = new int[range];
    
    for(int i = 0; i < arr.length; i++){
        // Shifting the elements to 0 axis : arr[i] - min ,and storing the frequency
        int idx = arr[i] - min; 
        freq[idx]++; 
    }
    
    // Calculate prefixSumOfLastPosition from freq array
    // prefix[i] = freq[0] + freq[1] + freq[2] + ... freq[i]
    // prefix[i] = prefix[i - 1] + freq[i]
    // But if i == 0, then prefix[i - 1] does not exists
    int[] prefixSumOfLastPosition = new int[range];
    for(int i = 0; i < freq.length; i++){
        if(i == 0) prefixSumOfLastPosition[i] = freq[i];
        else prefixSumOfLastPosition[i] =  prefixSumOfLastPosition[i - 1] + freq[i];
    }
    
    // Creating tempAns since we still need elements of arr or we would have sorted and stored in arr itself
    // Form New tempAns Array (To not modify input array while traversing the input array)
    // tempAns array will store all the elemnents in sorted order
    int[] tempAns = new int[arr.length];
    
    // We are processing input array(arr) in reverse order because prefixSumOfLastPosition array contains the last position
    // of that element. Hence, last element should be processed first
    for(int i = arr.length - 1; i >= 0; i--){
        
        // This idx is index of element in prefixSumOfLastPosition
        int idx = arr[i] - min;
        
        // We have stored position and we need idx so doing - 1
        tempAns[prefixSumOfLastPosition[idx] - 1] = arr[i];
        
        // PrefixSum is updated to store the value of last occurence of next element
        prefixSumOfLastPosition[idx]--;
    }
   
    // Sorting must be done in the original array hence copying it back from tempAns to arr 
    for(int i = 0; i < tempAns.length; i++){
        arr[i] = tempAns[i];
    }
  }
  //============================================================================================================================
  

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}
