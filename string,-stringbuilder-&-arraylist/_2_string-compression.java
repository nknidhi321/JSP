//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/string,-stringbuilder-&-arraylist/string-compression-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

	public static String compression(String str){
		String ans = "" + str.charAt(0);
		for(int i = 1; i < str.length(); i++){
		    if(str.charAt(i - 1) != str.charAt(i)){
		        ans += str.charAt(i);
		    }
		}
		return ans;
	}

	public static String compressionWithCount(String str){
		String ans = "";
		int counter = 1;
		
		for(int i = 1; i < str.length(); i++){
		    if(str.charAt(i - 1) != str.charAt(i)){
		        
		        //computing answer of previous character by standing at i
		        ans += str.charAt(i - 1);
		        if(counter > 1){
		            ans += counter;
		        }
		        
		        //setting counter of current character to 1
		        counter = 1;
		    }
		    else {  //if str.charAt(i - 1) == str.charAt(i)
		        counter++;  //simply increase counter
		    }
		}
		
		//handling the last character
		ans += str.charAt(str.length() - 1);
	    if(counter > 1) ans += counter;
	    
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression(str));
		System.out.println(compressionWithCount(str));
	}

}
