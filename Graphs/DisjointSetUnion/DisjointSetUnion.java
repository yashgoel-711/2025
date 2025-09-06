package Graphs.DisjointSetUnion;

public class DisjointSetUnion {
    static int n ;
    static int[] rank ;
    static int[] parent;

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int a , int b){
        int parentA = find(a);
        int parentB = find(b);
        int rankA = rank[parentA];
        int rankB = rank[parentB];

        if(rankA == rankB){
            parent[parentB] = parentA;
            rank[parentA]++;
        }
        else if(rankA > rankB){
            parent[parentB] = parentA;
        }
        else {
            parent[parentA] = parentB;
        }
    }

    public static void main(String args[]){
        n = 7;
        rank = new int[7];
        parent = new int[7];
        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i;
        }
        System.out.println(find(1));
        System.out.println(find(2));
        union(1, 2);
        union(3, 4);
        union(1, 4);
        System.out.println(find(2));
        System.out.println(find(4));
        System.out.println(rank[1]);


    }
}
