// https://pepcoding.com/resources/online-java-foundation/stacks-and-queues/duplicate-brackets-official/ojquestion

// If you get a closing bracket then pop until you get an opening bracket and also pop that '(' at last
// Note that the popped elements count between that opening and closing bracket should be greater than 0

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(haveDuplicateBrackets(str));
    }
   
    public static boolean haveDuplicateBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {
                if(stack.peek() == '(') return true;      // Opening and closing bracket k bich count zero that mtlb ek v element nahi tha => Duplicate bracket exists
                else {
                    while(!stack.isEmpty() && stack.peek() != '(') stack.pop();       // pop until you get an opening bracket
                    if(!stack.isEmpty()) stack.pop();    // pop that opening bracket also
                }
            }
            else {
                stack.push(ch);     // Baaki jo v elements aaye push kar do
            }
        }
        return false;
    }

}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
