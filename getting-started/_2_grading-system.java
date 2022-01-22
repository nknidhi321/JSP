// https://www.pepcoding.com/resources/online-java-foundation/getting-started/grading-system-official/ojquestion

// Making extra checks 

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int marks = scn.nextInt();

    if (marks > 90) System.out.println("excellent");
    else if (marks > 80 && marks <= 90) System.out.println("good");
    else if (marks > 70 && marks <= 80) System.out.println("fair");
    else if (marks > 60 && marks <= 70) System.out.println("meets expectations");
    else if (marks < 60) System.out.println("below par");
  }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// Not making extra checks
// More efficient

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int marks = scn.nextInt();

    if (marks > 90) System.out.println("excellent");
    else if (marks > 80) System.out.println("good");
    else if (marks > 70) System.out.println("fair");
    else if (marks > 60) System.out.println("meets expectations");
    else if (marks < 60) System.out.println("below par");
  }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
