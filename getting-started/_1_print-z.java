// https://www.pepcoding.com/resources/online-java-foundation/getting-started/print-z-official/ojquestion

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("*****");
        System.out.println("   *");
        System.out.println("  *");
        System.out.println(" *");
        System.out.println("*****");
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// Question : Find the greatest number among 3 distinct numbers

/*
    Making extra check 
       1) Kya a sbse bada hai ? // Dono remaining se compare karwa rahe hai
       2) Kya b sbse bada hai ? // Dono remaining se compare karwa rahe hai
       3) Kya c sbse bada hai ?
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        int a = 10;
        int b = 80;
        int c = 30;
    
        if( a > b && a > c) System.out.println("a is greatest " + a);
        else if(b > a && b > c) System.out.println("b is greatest " + b);   // Here we are making extra checks 
        else System.out.println("c is greatest " + c);
    }
}

//-------------------------------------------------------------------------------------------------------------

// More efficient

// Reducing extra check
// Agar a sbse bada nahi hai, mtlb ya toh b ya c sbse bada hoga


import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        int a = 10;
        int b = 80;
        int c = 30;
    
        if( a > b && a > c) System.out.println("a is greatest " + a);
        else if(b > c) System.out.println("b is greatest " + b);   // Here we are making extra checks 
        else System.out.println("c is greatest " + c);
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
