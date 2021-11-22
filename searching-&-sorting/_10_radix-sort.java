//https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/radix-sort-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {


  //=========================================================================================================================================================
  public static void radixSort(int[] arr) {
      
    //For radixSort countSort will run for max numbers's digit count
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length; i++){
        max = Math.max(max, arr[i]);
    }
    
    // 1st unit's placeValue will get sorted then ten's then hundred'd and so on..
    // Because left most digit is of higher precedence which makes the overall number a bigger number
    
    // NOTE: Suppose there are 2 numbers _ _507 [The empty spaces will have 0's while comparison *] and 51245
    // 1st sorting on => 7 and 5
    // 2nd soting on => 0 and 4
    // 3rd sorting on => 5 and 2
    // 4th sorting on => 0 and 1
    // 5th sorting on => 0 and 5
    
    int placeValue = 1; // Unit's place
    while(placeValue <= max) {
        countSort(arr, placeValue); //Perform count sort on every placeValue starting from unit's
        placeValue *= 10; // Incraesing placeValue's
    }
  }

  public static void countSort(int[] arr, int placeValue) {
    // Create Frequency of size equal to range of elements
    int[] freq = new int[10];  // Digits will be from 0 to 9, size => 10
    
    //Creating frequency array of respective placeValue's
    for(int i = 0; i < arr.length; i++){
        int digit = arr[i] / placeValue % 10; // * smaller number divided by larger number quotient is 0 // smaller number modulo by larger number remainder is 0
        freq[digit]++; 
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
        int digit = arr[i] / placeValue % 10; // Retrieving actual numbers to be sorted
        int pos = freq[digit]; // Retrieving pos of respective placeValue's elements 
        int idx = pos - 1; // Actually We have stored position in prefixSumOfLastPosition(freq), and we need idx so do - 1
        tempAns[idx] = arr[i]; // Storing the sorted number at it's correct position //NOTE: Actual number will get sorted, not the digit 
        freq[digit]--; // updated prefixSumOfLastPosition(freq) to store the position of last occurence of next element
    }
   
    // Sorting must be done in the original array hence copying it back from tempAns to arr 
    for(int i = 0; i < tempAns.length; i++){
        arr[i] = tempAns[i];
    }

    System.out.print("After sorting on " + placeValue + " place -> ");
    print(arr);
  }
  //=====================================================================================================================================================
  

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
