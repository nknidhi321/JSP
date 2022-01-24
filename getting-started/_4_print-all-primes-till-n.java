// https://www.pepcoding.com/resources/online-java-foundation/getting-started/print-all-primes-till-n-official/ojquestion

import java.util.*;

public class Main{
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int low = sc.nextInt();
       int high = sc.nextInt();
       
       for(int n = low; n <= high; n++){
           int factors = 0;
           for(int divisor = 2; divisor <= (int)Math.sqrt(n); divisor++){
               if(n % divisor == 0){
                   factors++;
                   break;
               }
           }
           if(factors == 0) System.out.println(n);
       }
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
