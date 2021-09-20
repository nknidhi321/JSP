//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/2d-arrays/ring-rotate-official/ojquestion
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
        int s = sc.nextInt();
        int k = sc.nextInt();
        
        int[] oneD = getOneDArray(s, arr);
        rotate(oneD, k);
        fillOneDArray(s, oneD, arr);
        
        display(arr);
    }
    
    public static int[] getOneDArray(int s, int[][] arr) {
        int frow = s - 1;
        int fcol = s - 1;
        int lrow = arr.length - s;
        int lcol = arr[0].length - s;
        int size = 2 * (lrow - frow + lcol - fcol);
        int[] oneD = new int[size];
        int counter = 0;
        
        //left wall
        for(int i = frow, j = fcol; i <= lrow; i++){
            oneD[counter] = arr[i][j];
            counter++;
        }
        fcol++;
        
        //bottom wall
        for(int j = fcol, i = lrow; j <= lcol; j++){
            oneD[counter] = arr[i][j];
            counter++;
        }
        lrow--;
        
        //right wall
        for(int i = lrow, j = lcol; i >= frow; i--){
            oneD[counter] = arr[i][j];
            counter++;
        }
        lcol--;
        
        //top wall
        for(int j = lcol, i = frow; j >= fcol; j--){
            oneD[counter] = arr[i][j];
            counter++;
        }
        frow++;
        
        return oneD;
    }
    
    public static void rotate(int[] a, int k) {
		int n = a.length;
		k = ((k % n) + n) % n;
		reverse(a, 0, n - 1);
		reverse(a, 0, k - 1);
		reverse(a, k, n - 1);
	}

	public static void reverse(int[] a, int i, int j) {
		while (i < j) {
			int temp = a[j];
			a[j--] = a[i];
			a[i++] = temp;
		}
	}
	
	public static void fillOneDArray(int s, int[] oneD, int[][] arr) {
        int frow = s - 1;
        int fcol = s - 1;
        int lrow = arr.length - s;
        int lcol = arr[0].length - s;
        int size = 2 * (lrow - frow + lcol - fcol);
        int counter = 0;
        
        //left wall
        for(int i = frow, j = fcol; i <= lrow; i++){
            arr[i][j] = oneD[counter];
            counter++;
        }
        fcol++;
        
        //bottom wall
        for(int j = fcol, i = lrow; j <= lcol; j++){
            arr[i][j] = oneD[counter];
            counter++;
        }
        lrow--;
        
        //right wall
        for(int i = lrow, j = lcol; i >= frow; i--){
            arr[i][j] = oneD[counter];
            counter++;
        }
        lcol--;
        
        //top wall
        for(int j = lcol, i = frow; j >= fcol; j--){
            arr[i][j] = oneD[counter];
            counter++;
        }
        frow++;
    
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
