// https://www.pepcoding.com/resources/online-java-foundation/getting-started/is-number-prime-official/ojquestion

// NOTE : 1 is prime as per their portal
// 1 and n se toh sab number divisible hoga he, so check for (1, n) exclusively
// More efficient : Check only until sq root of the number 

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

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
