//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/recursion-in-arraylist/get-subsequence-official/ojquestion

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws Exception {
//         Scanner sc = new Scanner(System.in);
//         String s = sc.next();
//         ArrayList<String> ans = gss(s);
//         System.out.println(ans);
//     }

//     public static ArrayList<String> gss(String s) {
//         if(s.length() == 0){
//             ArrayList<String> list = new ArrayList<>();
//             list.add("");
//             return list;
//         }
        
//         char ch = s.charAt(0);
//         ArrayList<String> list = gss(s.substring(1));
//         ArrayList<String> ans = new ArrayList<String>();
//         for(String str : list){
//             ans.add("" + str); 
//         }
//         for(String str : list){
//             ans.add(ch + str); 
//         }
//         return ans;
//     }

// }


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> ans = gss(s);
        System.out.println(ans);
    }

    public static ArrayList<String> gss(String s) {
        return gss_Util(s, 0);
    }
    
    public static ArrayList<String> gss_Util(String s, int idx) {
        if(idx == s.length()){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        
        char ch = s.charAt(idx);
        ArrayList<String> list = gss_Util(s, idx + 1);
        ArrayList<String> ans = new ArrayList<String>();
        for(String str : list){
            ans.add("" + str); 
        }
        for(String str : list){
            ans.add(ch + str); 
        }
        return ans;
    }

}
