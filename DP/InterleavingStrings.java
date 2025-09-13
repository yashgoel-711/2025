package DP;

public class InterleavingStrings {
    public static boolean check(String s3 , String s1 , String s2 , int i , int j , int k , int[][] dp ){

        if(k >= s3.length()){
            if(i >= s1.length() && j >= s2.length()){  
                dp[i][j] = 1 ;              
                return true;
            } else {
                dp[i][j] = -1;
                return false; 
            }
        }
           
        
       
        boolean result = false ;

         if(i < s1.length() && s3.charAt(k) == s1.charAt(i)){
            //s1 matches
            if(dp[i + 1][j] != 0){
                result = dp[i + 1][j] == 1 ;
            } else {
                result = check( s3 ,  s1 ,  s2 ,  i + 1 ,  j ,  k + 1 , dp);
            }
            dp[i][j] = result ? 1 : -1 ;
        }
        if(result){
            return result ;
        }

        if(j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            //s2 matches
            if(dp[i][j + 1] != 0){
                result = dp[i][j + 1] == 1 ;
            } else {
                result = check( s3 ,  s1 ,  s2 ,  i  ,  j + 1 ,  k + 1 , dp);
            }
            dp[i][j] = result ? 1 : -1 ;
        }

        return result ;

    }
    public static void main(String args[]){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        int dp[][] = new int[s1.length() + 1][s2.length() + 1] ;

        if(s3.length() != s1.length() + s2.length()){
            System.out.println(false);
        } else {
            System.out.println(check( s3 ,  s1 ,  s2 , 0 , 0 , 0 , dp ));
        }
    }
}
