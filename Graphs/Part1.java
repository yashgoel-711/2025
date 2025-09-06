package Graphs;

import java.util.*;

public class Part1 {

    static class Edge{
        int src ;
        int dest;
        int w ;
        Edge(int s , int d , int w){
            this.src = s;
            this.dest = d;
            this.w = w;
        }
    }

    public static ArrayList<Edge>[] createGraph(){

        int v = 5;
        ArrayList<Edge> edge[] = new ArrayList[v]; 

        for(int i = 0 ; i < v ; i++){
            edge[i] = new ArrayList<>();
        }

        edge[0].add(new Edge(0, 1, 5));
        
        edge[1].add(new Edge(1, 0, 5));
        edge[1].add(new Edge(1, 3, 3));
        edge[1].add(new Edge(1, 2, 1));
        
        edge[2].add(new Edge(2, 1, 1));
        edge[2].add(new Edge(2, 3, 1));
        edge[2].add(new Edge(2, 4, 2));
        
        edge[3].add(new Edge(3, 1, 3));
        edge[3].add(new Edge(3, 2, 1));
        
        edge[3].add(new Edge(4, 2, 2));       

        return edge;
    }
  
    public static void BFS(ArrayList<Edge>[] edge){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[edge.length];
        
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0 ; i < edge[curr].size() ; i++){
                    q.add(edge[curr].get(i).dest);
                }
            }
        }

    }
   
   public static void DFS(ArrayList<Edge>[] edge, int curr , boolean[] visited){

        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i = 0 ; i < edge[curr].size() ; i++){
            if(!visited[edge[curr].get(i).dest]){
                DFS(edge, edge[curr].get(i).dest, visited);
            }
        }
   }
   
   
    public static void main(String args[]){

        ArrayList<Edge> edge[] = createGraph();
        DFS(edge , 0 , new boolean[edge.length]);
    }
}
