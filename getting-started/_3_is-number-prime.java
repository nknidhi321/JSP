//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/getting-started/is-number-prime-official/ojquestion
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       int factor;
       
       for(int i = 0; i < t; i++){
           int n = sc.nextInt();
           factor = 0;
           if(n == 1){
              //n is prime as per their portal 
              System.out.println("prime");
              continue;
           }              
           for(int div = 2; div <= (int)Math.sqrt(n); div++){
               if(n % div == 0){
                   factor++;
                   System.out.println("not prime");
                   break;
               }
           }
           if(factor == 0) System.out.println("prime");
       }
   }
  }
