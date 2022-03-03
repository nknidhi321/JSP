//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/2d-arrays/saddle-price-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        boolean foundSaddlePoint = false;
        
        for(int i = 0; i < n; i++){
            
            //Finding minimum val of each row
            int min = Integer.MAX_VALUE;
            int minColIndex = -1;
            for(int col = 0; col < n; col++){
                if(arr[i][col] < min){
                    min = arr[i][col];
                    minColIndex = col;
                }
            }
            
            //Finding maximum val of the minColIndex th column
            int max = Integer.MIN_VALUE;
            for(int row = 0; row < n; row++){
                if(arr[row][minColIndex] > max){
                    max = arr[row][minColIndex];
                }
            }
            
            //If both min and max is same that is the saddle Point
            if(min == max){
                foundSaddlePoint = true;
                System.out.println(min);
                break;
            }
   
        }
        if(!foundSaddlePoint) System.out.println("Invalid input");
    }

}
