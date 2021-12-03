//https://pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-subsequence-official/ojquestion

//By passing idx in the recursive call
//Efficient Approach

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        return getsubSequence(0, str);
    }
    
      //getType
      public static ArrayList<String> getsubSequence(int idx, String str) {
             if(idx == str.length()) {
                    ArrayList<String> base = new ArrayList<>();
                    base.add("");
                    return base;
              }

              ArrayList<String> smallAns = getsubSequence(idx + 1, str);

              //Nahi aane ki choice 
              //As it is jo smallAns me aaya usko final answer me daal diye
              ArrayList<String> ans = new ArrayList<>(smallAns);

              //Aane ki choice
              //Is baar saare smallAns k aage khud ko add append kar lo and add in final ans
              char ch = str.charAt(idx);
              for(String s : smallAns) {
                    ans.add(ch + s);
              }

              return ans;
        }

}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

//By passing substring in the recursive call
//Less efficient //String ko katne ki coplexity O(N) hoti hai

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(gss(str));
    }

    //get Type
    public static ArrayList<String> gss(String str) {
        if(str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        
        ArrayList<String> smallAns = gss(str.substring(1));
        
        //Nahi aane ki choice 
	//As it is jo smallAns me aaya usko final answer me daal diye
        ArrayList<String> ans = new ArrayList<String>(smallAns);
        
        //Aane ki choice
	//Is baar saare smallAns k aage khud ko add append kar lo and add in final ans
        char ch = str.charAt(0);
        for(String s : smallAns) {
            ans.add(ch + s); 
        }
        
        return ans;
    }

}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
