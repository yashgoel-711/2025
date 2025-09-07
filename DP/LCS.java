package DP;

public class LCS {

    public static int findLCSRecursive(String s1 , int n , String s2 , int m){
        if(m == 0 || n == 0){
            return 0;
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            return 1 + findLCSRecursive( s1 ,  n - 1 ,  s2 ,  m - 1);
        }
        int ans1 = findLCSRecursive( s1 ,  n  ,  s2 ,  m - 1);
        int ans2 = findLCSRecursive( s1 ,  n - 1 ,  s2 ,  m );

        return Math.max(ans1 , ans2) ;
    }


    public static int findLCSMemoization(String s1 , int n , String s2 , int m , int[][] dp){
         if(m == 0 || n == 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            dp[n][m] = 1 + findLCSMemoization( s1 ,  n - 1 ,  s2 ,  m - 1 , dp);
            return dp[n][m];
        }
        int ans1 = findLCSMemoization( s1 ,  n  ,  s2 ,  m - 1 , dp);
        int ans2 = findLCSMemoization( s1 ,  n - 1 ,  s2 ,  m , dp);

        dp[n][m] = Math.max(ans1 , ans2) ;
        return dp[n][m];
    }


    public static void main(String args[]){
        String s1 = "abcde";
        String s2 = "ace" ;
        // int ans = findLCSRecursive( s1 ,  s1.length()  ,  s2 ,  s2.length());

        int dp[][] = new int[s1.length() + 1][s2.length() + 1] ;
        for(int  i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[i].length ; j++){
                dp[i][j] = -1;
            }
        }

        int ans = findLCSMemoization( s1 ,  s1.length()  ,  s2 ,  s2.length() , dp);


        System.out.println(ans);

    }
}
