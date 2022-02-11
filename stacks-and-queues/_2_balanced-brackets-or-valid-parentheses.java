// https://leetcode.com/problems/valid-parentheses/

class Solution {
    
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        
        // Sirf opening and closing brackets k liye kaam karenge
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            // Jo v opening brackets aaega push kar do
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            
            // Koi opening bracket nai hai stack me and koi closing bracket aa gaya => Order mismatched
            else if(stack.isEmpty() && (ch == ')' || ch == '}' || ch == ']')) return false; 
            
            // Ek specific type k opening bracket k corresponding wahi specific closing bracket nahi mila stack k top pe => Wrong
            else if((ch == ')' && stack.peek() != '(' ) || (ch == '}' && stack.peek() != '{' ) || (ch == ']' && stack.peek() != '[' )) return false; 
            
            // Ek specific type k opening bracket k corresponding wahi specific closing bracket mila gaya stack k top pe then
            // Ek sahi pair mil gaya => pop kar do stack k top ko => Discard that pair kuki end me sirf galat log stack me bachenge
            else if((ch == ')' && stack.peek() == '(' ) || (ch == '}' && stack.peek() == '{' ) || (ch == ']' && stack.peek() == '[' )) stack.pop();
        }
        
        // Kuki saare sahi pairs ko humne stack se pop karwa diya tha => Ab jo stack me bache hai wo sirf '(' || '{' || '[' opening brackets honge 
        // jinke pairs nahi mile 
        // So check karo agar stack khali hai mtlb sbke pairs mil gaye honge 
        // Agar khali nahi hai then sbke pairs nahi mile
        return stack.isEmpty() ? true : false;
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// https://pepcoding.com/resources/online-java-foundation/stacks-and-queues/balanced-brackets-official/ojquestion
// Same code at pepcoding without comments

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isBalancedBrackets(str));
    }
    
  
    public static boolean isBalancedBrackets(String str) {
       Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            
            else if(stack.isEmpty() && (ch == ')' || ch == '}' || ch == ']')) return false; 
            else if((ch == ')' && stack.peek() != '(' ) || (ch == '}' && stack.peek() != '{' ) || (ch == ']' && stack.peek() != '[' )) return false; 
            
            else if((ch == ')' && stack.peek() == '(' ) || (ch == '}' && stack.peek() == '{' ) || (ch == ']' && stack.peek() == '[' )) stack.pop();
        }
        
        return stack.isEmpty() ? true : false;
    }

}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
