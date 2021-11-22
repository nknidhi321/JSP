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
    
    // Convert freq array into prefixSumOfLastPosition array [freq array is calulated only to get prefixSumOfLastPosition]
    for(int i = 1; i < freq.length; i++){
        freq[i] += freq[i - 1];
    }
    
    // Form New tempAns Array (To not modify input array while traversing the input array)
    // tempAns array will store all the elemnents in sorted order
    int[] tempAns = new int[arr.length];
    
    // We are processing input array(arr) in reverse order because prefixSumOfLastPosition(freq) array contains the last position
    // of that element. Hence, last element should be processed first
    for(int i = arr.length - 1; i >= 0; i--){
        int num = arr[i]; // Retrieving actual numbers to be sorted
        int pos = freq[num - min]; // Retrieving pos of elements which was Shifted to 0 axis
        int idx = pos - 1; // Actually We have stored position in prefixSumOfLastPosition(freq), and we need idx so do - 1
        tempAns[idx] = num; // Storing the sorted number at it's correct position
        freq[num - min]--; // updated prefixSumOfLastPosition(freq) to store the position of last occurence of next element
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
