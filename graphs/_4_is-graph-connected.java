//https://www.pepcoding.com/resources/online-java-foundation/graphs/is-graph-connected-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
    
   //======================================================================================================================
   //get Connected Component
   public static void gcc(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps) {
       int N = graph.length;
       boolean[] vis = new boolean[N];
       for(int i = 0; i < N; i++){
           if(!vis[i]){
               ArrayList<Integer> subList = new ArrayList<>();
               dfsComponent(graph, i, vis, subList, comps);
               comps.add(subList);
           }
       }
   }
   
   public static void dfsComponent(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> subList, ArrayList<ArrayList<Integer>> comps){
       subList.add(src);
       vis[src] = true;
       for(Edge e : graph[src]){
           if(!vis[e.nbr]){
              dfsComponent(graph, e.nbr, vis, subList, comps);
           }
       }
   }
   //=====================================================================================================================

    
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      
      //====================================================================================================================
      // write your code here
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      gcc(graph, comps);
      System.out.println(comps.size() == 1);
      //====================================================================================================================
   }
}
