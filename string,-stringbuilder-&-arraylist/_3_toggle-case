//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/string,-stringbuilder-&-arraylist/toggle-case-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
	    String ans = "";
		for(int i = 0; i < str.length(); i++){
		    if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
		        ans += (char)(str.charAt(i) + 32);
		    }
		     else if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
		        ans += (char)(str.charAt(i) - 32);
		    }
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}
