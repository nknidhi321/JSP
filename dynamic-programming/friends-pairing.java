// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/friends-pairing-official/ojquestion

// Sumeet Malik
// Dp will store tum khud se leke n tak kitne tareeko se jaa saktey ho
// Levels pe har ek frnd hoga ek baar, pehle 0, 1, 2, so on...

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] visited = new boolean[n];
        System.out.println(pairing(0, n, visited));
    }
    
    // Levels pe har ek frnd hoga ek baar, pehle 0, 1, 2, so on...
    public static int pairing(int idx, int n, boolean[] visited) {
        if(idx == n) return 1; // Sbko process kar liya => Ek tareeka mil gaya 
        
        int count = 0;
        
        // Your fate is already decided by someone, aage badh jaao, someone already made pair with you from prev calls
        if(visited[idx]) count += pairing(idx + 1, n, visited);
        
        // Tumhe kvi kisi ne nahi choona => Ab tumhare pass 2 choice hai 1)akele jaao 2) Kisi k saath jaao
        else {
            visited[idx] = true; // Mark yourself as visited
            
            // Akele jaane ki choice
            count += pairing(idx + 1, n, visited);
            
            // Kisi k saath jaane ki choice
            for(int i = idx + 1; i < n; i++) {
                if(!visited[i]) { // Jiske saath jaana chahte ho wo visited nahi h
                    visited[i] = true; // Toh tum uske saath chale jaao
                    count += pairing(idx + 1, n, visited); // Here idx + 1 he pass hoga kuki har ek ka apna level hoga 0, 1, 2, so on..
                    visited[i] = false; // Backtrack the frnd, jiske saath gaye the
                }
            }
            visited[idx] = false; // Backtrack, unmark yourself
        }
        return count; // Jitne v tareeke aaye uska count 
    } 

}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
