// https://www.pepcoding.com/resources/online-java-foundation/getting-started/reverse-a-number-official/ojquestion

import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here  
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     while(n > 0){
         System.out.println(n % 10);
         n = n / 10;
     }
    }
   }
