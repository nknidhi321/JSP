//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/2d-arrays/rotate-by-90-degree-official/ojquestion
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
    
        //Transpose
        for(int i = 0; i < n ; i++){
            for(int j = i + 1; j < n ; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
        //Reverse
        for(int row = 0; row < n; row++){
            reverse(arr, row);
        }
        
        display(arr);
    }
    
    
    public static void reverse(int[][] arr, int row){
            int i = 0;
            int j = arr[row].length - 1;
            while(i < j) {
                int temp = arr[row][i];
                arr[row][i] = arr[row][j];
                arr[row][j] = temp;
                i++;
                j--;
            }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
