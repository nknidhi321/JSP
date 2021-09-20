//https://classroom.pepcoding.com/myClassroom/the-switch-program-4/dynamic-programming/climb-stairs-with-variable-jumps-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] moves = new int[n];
    for (int i = 0; i < n; i++) {
      moves[i] = sc.nextInt();
    }

    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
  //System.out.println(path_memo(0, moves, dp));

    System.out.println(path_tab(n, moves));
  }


  public static int path_memo(int n, int[] moves, int[] dp) {
    if (n == moves.length) return dp[n] = 1;

    if (dp[n] != -1) return dp[n];

    int count = 0;
    for (int jumps = 1; jumps <= moves[n]; jumps++) {
      if (n + jumps <= moves.length) {
        count += path_memo(n + jumps, moves, dp);
      }
    }
    return dp[n] = count;
  }


 public static int path_tab(int N, int[] moves) {
    int[] dp = new int[N + 1];
    
    for(int n = moves.length; n >= 0; n--){
        if (n == moves.length){
            dp[n] = 1;
            continue;
        }
    
        int count = 0;
        for (int jumps = 1; jumps <= moves[n]; jumps++) {
          if (n + jumps <= moves.length) {
            count += dp[n + jumps];
          }
        }
        dp[n] = count;
    }
    return dp[0];
  }

}
