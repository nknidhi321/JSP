//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/searching-&-sorting/partition-an-array-official/ojquestion

//Group : Seregation of two types of elements

import java.io.*;
import java.util.*;

public class Main {

  public static void partition(int[] arr, int pivot){
    //write your code here
    
    //ptr will point to last element which is <= pivot upto the explored array elements
    int ptr = -1;
    int itr = 0;
    while(itr < arr.length){
        
        //Increase ptr and then swap
        if(arr[itr] <= pivot) swap(arr, itr++, ++ptr);
        //now increase itr because after swapping itr will always point to an element > pivot
        //so why to check that 
        //Why ? Because we simply increase our pointer when we find an element > pivot
        
        else itr++;
    }
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

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
    int pivot = scn.nextInt();
    partition(arr,pivot);
    print(arr);
  }

}
