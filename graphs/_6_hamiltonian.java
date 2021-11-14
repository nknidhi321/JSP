//https://www.pepcoding.com/resources/online-java-foundation/graphs/hamiltonian-official/ojquestion

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

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      int N = graph.length;
      boolean[] vis = new boolean[N];
      ArrayList<String> ans = new ArrayList<>();
      hamiltonainPathAndCycle(graph, src, 0, 0, vis, "", ans);
      for(String paths : ans){
          System.out.println(paths);
      }
   }

  //======================================================================================================================================================
	/*
	  What is Hamiltonian Path ?
	  1. Single Source, any random source
	  2. Should travel through all the nodes only once in any sequence
	  
	  What is Hamiltonian Cycle(Mark with *) ?
	  1. Single Source 
	  2. Should travel through all the nodes only once in any sequence
	  3. The last node should have direct edge with the original source node 
	 */
	
	// E = v - 1
	public static void hamiltonainPathAndCycle(ArrayList<Edge>[] graph, int src, int osrc, int edgeCount, boolean[] vis, String psf, ArrayList<String> ans) {
	    //Found Hamiltonian Path
        if(edgeCount == graph.length - 1) {
            psf += src;
            
            //osrc is required to find directEdge for Hamiltonian Cycle when Hamiltonian Path is found
            int idx = findEdge(graph, src, osrc);
            if (idx != -1) { //Found a direct edge
                psf += '*'; //Adding mark for Hamiltonian Cycle
            }
            else { //Not found a direct edge
                psf += ".";  //Adding mark for Hamiltonian Path
            }
            
            //NOTE: We have psf as String so no backtracking needed
            //But if it would have been of type ArrayList 
            //then you would be backtracking from the list and removing the last node to explore Allpaths
            ans.add(psf);  //Adding ans to our ans List
            return;
        }

        vis[src] = true;  //Mark visited
        for(Edge e : graph[src]) {
            if(!vis[e.nbr]) { //Calls on unvisited nbr's
            	hamiltonainPathAndCycle(graph, e.nbr, osrc, edgeCount + 1, vis, psf + src, ans);
            }
        }
        vis[src] = false;  //Backtrack //AllPaths
    }
    
    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
        
       //Exploring all edges of node u to find if u has any direct edge to originalSource
		for(int i = 0; i < graph[u].size(); i++) {
			Edge e = graph[u].get(i);
			if(e.nbr == v) {
				return i; //idx at which the edge is found in the ArrayList
			}
		}
		return -1; //No direct edge found
	}
	//===================================================================================================================================================

}
