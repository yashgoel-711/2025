package DP ;

public class WildCardMatching {
    public static void main(String args[]){
        String s = "aab";
        String p = "b*" ;

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1] ;

        dp[0][0] = true;
        for(int j = 1 ; j < dp[0].length ; j++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i = 1 ; i < dp.length ; i++ ){
            for(int j = 1 ; j < dp[i].length ; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] ;
                }
                else {
                    dp[i][j] = false ;
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
