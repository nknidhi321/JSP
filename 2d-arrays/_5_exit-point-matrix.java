//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/2d-arrays/exit-point-matrix-official/ojquestion
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
        
        int dir = 0;
        int i = 0, j = 0;
        while(true){
            dir = (dir + arr[i][j]) % 4;
            if(dir == 0) j++;
            else if(dir == 1) i++;
            else if(dir == 2) j--;
            else if(dir == 3) i--;
            
            if(i < 0){
                System.out.println(++i);
                System.out.println(j);
                return;
            }
            else if(i >= n){
                System.out.println(--i);
                System.out.println(j);
                return;
            }
            else if(j < 0){
                System.out.println(i);
                System.out.println(++j);
                return;
            }
            else if(j >= m){
                System.out.println(i);
                System.out.println(--j);
                return;    
            }
        }
    }

}
