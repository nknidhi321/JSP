//https://pepcoding.com/resources/online-java-foundation/graphs/perfect-friends-official/ojquestion
//Refer Level for more Approaches //Journey To Moon 

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Integer>[] graph = new ArrayList[n];
      for(int i = 0; i < n; i++) {
          graph[i] = new ArrayList<>();
      }
      
      for(int i = 0; i < k; i++) {
          String[] parts = br.readLine().split(" ");
          int u = Integer.parseInt(parts[0]);
          int v = Integer.parseInt(parts[1]);
          graph[u].add(v);
          graph[v].add(u);
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] vis = new boolean[n];
      for(int i = 0; i < n; i++) {
          if(!vis[i]) {
              comps.add(dfs_component(i, vis, new ArrayList<>(), graph));
          }
      }
      
      int pairCount = 0;
      for(int i = 0; i < comps.size(); i++) {
          for(int j = i + 1; j < comps.size(); j++) {
              pairCount += comps.get(i).size() * comps.get(j).size();
          }
      }
      
      System.out.println(pairCount);
   }
   
   public static ArrayList<Integer> dfs_component(int src, boolean[] vis, ArrayList<Integer> comp, ArrayList<Integer>[] graph) {
       vis[src] = true;
       comp.add(src);
       for(int nbr : graph[src]) {
           if(!vis[nbr]) {
               dfs_component(nbr, vis, comp, graph);
           }
       }
       return comp;
   }

}
