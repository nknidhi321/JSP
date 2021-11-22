//https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/sort-dates-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {

  
  //=============================================================================================================================
  public static void sortDates(String[] arr) { 
    countSort(arr, 1000000, 100, 32);  // Days // Lowest precedence hence sorted first
    countSort(arr, 10000, 100, 13);  // Month // Greater predence than date but less precedence than year
    countSort(arr, 1, 10000, 2501);  // Year // Highest precedenc hence sorted at last
  }

  public static void countSort(String[] arr,int placeValue, int mod, int range) {
    // Create Frequency of size equal to range of elements
    int[] freq = new int[range]; //0th idx will be useless, no 0th date month or year
    
    //Creating frequency array of respective dd_Or_mm_Or_yyyy placeValue
    for(int i = 0; i < arr.length; i++) {
        
        //NOTE: Make sure to use base 10, say for 06 date, machine would be taking this in octal because of seeing 0 before 6
        //So inorder to have it in decimal base 10, use Integer.parseInt(arr[i], 10)
        int dd_Or_mm_Or_yyyy = Integer.parseInt(arr[i], 10) / placeValue % mod; 
        freq[dd_Or_mm_Or_yyyy]++; 
    }
    
    // Convert freq array into prefixSumOfLastPosition array [freq array is calulated only to get prefixSumOfLastPosition]
    for(int i = 1; i < freq.length; i++) {
        freq[i] += freq[i - 1];
    }
    
    // Form New tempAns Array (To not modify input array while traversing the input array)
    // tempAns array will store all the elemnents in sorted order
    String[] tempAns = new String[arr.length];
    
    // We are processing input array(arr) in reverse order because prefixSumOfLastPosition(freq) array contains the last position
    // of that element. Hence, last element should be processed first
    for(int i = arr.length - 1; i >= 0; i--) {
        int dd_Or_mm_Or_yyyy = Integer.parseInt(arr[i], 10) / placeValue % mod; // Retrieving actual dd_Or_mm_Or_yyyy to be sorted
        int pos = freq[dd_Or_mm_Or_yyyy]; // Retrieving pos of respective dd_Or_mm_Or_yyyy placeValue's elements 
        int idx = pos - 1; // Actually We have stored position in prefixSumOfLastPosition(freq), and we need idx so do - 1
        tempAns[idx] = arr[i]; // Storing the ddmmyyyy at it's correct position //NOTE: Actual ddmmyyyy will get sorted, not dd_Or_mm_Or_yyyy 
        freq[dd_Or_mm_Or_yyyy]--; // Updated prefixSumOfLastPosition(freq) to store the position of last occurence of next element
    }
   
    // Sorting must be done in the original array hence copying it back from tempAns to arr 
    for(int i = 0; i < tempAns.length; i++) {
        arr[i] = tempAns[i];
    }
  }
  //===========================================================================================================================================
  
  

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}
