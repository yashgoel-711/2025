package DP;

import java.util.ArrayList;

public class Triangle {



    public static void minPathSum(  ArrayList<ArrayList<Integer>> triangle , int level    ,  int dp[][] ){

        if(level < 0){            
            return ;
        }


       
            
        
       for(int i = 0 ; i < triangle.get(level).size() ; i++){
            dp[level][i] = Math.min(dp[level + 1][i] , dp[level + 1][i + 1]) + triangle.get(level).get(i);
       }
                
        minPathSum(  triangle , level - 1  ,  dp ) ;

        return ;

        
    }

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>() ;
        triangle.add(new ArrayList<>());
        triangle.get(0).add(2);
        triangle.add(new ArrayList<>());
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        triangle.add(new ArrayList<>());
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        triangle.add(new ArrayList<>());
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

        int dp[][] = new int[triangle.size() + 1][triangle.size() + 1] ;
        minPathSum( triangle , triangle.size() - 1  ,   dp) ;

        System.out.println(dp[0][0]) ;



    }
}
