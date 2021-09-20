//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/2d-arrays/spiral-display-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
             }
        }
        
        int frow = 0;
        int fcol = 0;
        int lrow = n - 1;
        int lcol = m - 1;
        
        int counter = 0;
        while(counter < n * m){
            for(int i = frow; i <= lrow; i++){
                int j = fcol;
                System.out.println(arr[i][j]);
                counter++;
                if(counter == n * m) return;
            }
            fcol++;
            
            for(int j = fcol; j <= lcol; j++){
                int i = lrow;
                System.out.println(arr[i][j]);
                counter++;
                if(counter == n * m) return;
            }
            lrow--;
            
            for(int i = lrow; i >= frow; i--){
                int j = lcol;
                System.out.println(arr[i][j]);
                counter++;
                if(counter == n * m) return;
            }
            lcol--;
            
            for(int j = lcol; j >= fcol; j--){
                int i = frow;
                System.out.println(arr[i][j]);
                counter++;
                if(counter == n * m) return;
            }
            frow++;
        }
        
    }

}
