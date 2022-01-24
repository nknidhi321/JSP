// https://www.pepcoding.com/resources/online-java-foundation/getting-started/digits-of-a-number-official/ojquestion

import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int temp = n;

    // Count number Of Digits
    int numberOfDigits = 0;
    while (temp > 0) {
      numberOfDigits++;
      temp /= 10;
    }
    
    // Calculate divisor
    int divisor = (int)Math.pow(10, numberOfDigits - 1);
    
	  
    // You have to move from left to right of the number inorder to print
    
    // Here don't write n > 0 instead of divisor > 0, because here we are moving from left to right. 
    // Ex : n = 1000, So next n will be 000, and your loop will break without printing the three 0's [since your n is already 0]
	while (divisor > 0) {	 // NOTE : divisor is truncating the last digit from right to left like in temp, that's why divisor > 0 is working and n > 0 will not work 
	  int q = n / divisor;   // Left part of the number 
      int r = n % divisor;   // Right part of the number
      System.out.println(q);
      n = r;                 // Right part will be you new n
      divisor /= 10;         // At each iteration divisor will reduce by 1 zero
    }
  }
}
