package DP;

public class ClimbingStairs {

    static int ClimbingWaysRecursive(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        return ClimbingWaysRecursive(n-1) + ClimbingWaysRecursive(n-2);
    }
    
    public static void main(String args[]){
        System.out.println(ClimbingWaysRecursive( 5));
    }
}
