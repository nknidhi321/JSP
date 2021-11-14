//https://www.pepcoding.com/resources/online-java-foundation/graphs/count-islands-official/ojquestion
//Refer Level up code for other approaches

import java.io.*;
import java.util.*;

public class Main {
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
      System.out.println(numIslands(arr));
   }
    
    
    //====================================================================================================
    // write your code here
    public static int numIslands(int[][] grid) {
        int count = 0;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    count += dfs(i, j, dir, grid);
                }
            }
        }
        return count;
    }
    
    public static int dfs(int i, int j, int[][] dir, int[][] grid) {
        grid[i][j] = 1;
        for(int d = 0; d < dir.length; d++){
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0)
                dfs(x, y, dir, grid);
        }
        return 1;
    }
    //====================================================================================================

}
