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
    public static void main(String args[]){
        String s1 = "abcde";
        String s2 = "ace" ;
        int ans = findLCSRecursive( s1 ,  s1.length()  ,  s2 ,  s2.length());

        System.out.println(ans);

    }
}
