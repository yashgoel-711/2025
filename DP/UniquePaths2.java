package DP;

public class UniquePaths2 {
    

    public static void isPath(int[][] grid , int i , int j , int dp[][]){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length){
            return ;
        }
        if(grid[i][j] == 1){
            dp[i][j] = -1;
            return ;
        }
      

        if(dp[i][j + 1] == 0){
            isPath( grid ,  i ,  j + 1 , dp) ;
        } 
         if(dp[i][j + 1] == 1) {
            dp[i][j] +=  dp[i][j + 1] ;
        }

        if(dp[i + 1][j] == 0){
            isPath( grid ,  i + 1 ,  j , dp) ;
        } 
         if(dp[i + 1][j] == 1){
            dp[i][j] +=  dp[i + 1][j] ;
        }


       
        isPath( grid ,  i + 1 ,  j , dp) ;

    }

    public static void main(String args[]){
        

        int[][] grid = new int[3][3] ;
        grid[1][1] = 1;

        int[][] dp = new int[3 + 1][3 + 1] ;
        dp[2][2] = 1;
        for(int i = 0 ; i < 4 ; i++){
            dp[3][i] = -1 ;
            dp[i][3] = -1 ;
        }

        isPath( grid ,  0 ,  0 , dp) ;

        System.out.println(dp[0][0]);
    }
}
