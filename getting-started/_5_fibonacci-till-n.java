// https://www.pepcoding.com/resources/online-java-foundation/getting-started/fibonacci-till-n-official/ojquestion
// Mine // Ignore

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      // write your code here
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int first = 0;
      int second = 1;
      System.out.println(first);
      System.out.println(second);
      n = n - 2; 
      int sum = 0;
      while(n-- > 0){
            sum = first + second;
            System.out.println(sum);
            first = second;
            second = sum;
      }
   }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
// Jassi

Note : a will always contain all the fibo numbers till n at each iteration

import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      
      int a = 0;
      int b = 1;
      for(int i = 1; i <= n; i++) {
            System.out.println(a);
            int c = a + b;
            a = b;
            b = c;
      }
   }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
