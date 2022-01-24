// https://www.pepcoding.com/resources/online-java-foundation/getting-started/is-number-prime-official/ojquestion

// NOTE : 1 is prime as per their portal
// 1 and n se toh sab number divisible hoga he, so check for (1, n) exclusively

// 10^9 operation -> 1 sec
// Acc to constraints while loop will run for 10^4 times and for loop will run for 10^9 times
// 10^4 * 10^9 => 10^13 operations which cannot be done in 1 sec => TLE

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();

    while (tc-- > 0) {
      int n = sc.nextInt();
      int factors = 0;
      for (int divisor = 2; divisor < n; divisor++) { 
        if (n % divisor == 0) {
          factors++;
          break;
        }
      }
      if (factors == 0) System.out.println("prime");
      else System.out.println("not prime");
    }
  }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// More efficient : Check only until sq root of the number 

// 10^9 operation -> 1 sec
// Acc to constraints while loop will run for 10^4 times and for loop will run for sq. root of 10^9 times

/*
    f1 * f2 = n, where f1 = smallFactor and f2 = largeFactor and f1 <= f2, 
    therefore find the maximum range of f1, so replace f2 with f1
    f1 * f1 = n => f1 = root n
    Range : [2, root n]
*/

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();

    while (tc-- > 0) {
      int n = sc.nextInt();
      int factors = 0;
      for (int divisor = 2; divisor <= (int)Math.sqrt(n); divisor++) {
        if (n % divisor == 0) {
          factors++;
          break;
        }
      }
      if (factors == 0) System.out.println("prime"); // [2, root(n)] tak ek v factor nahi mila 
      else System.out.println("not prime"); // [2, root(n)] tak koi factor mil gaya 
    }
  }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
