package DP;

public class TargetSumSubset {

    public static boolean targetSumSubset(int[] nums ,int i, int target , int dp[][]){

       
        if(i < 0 || target < 0){
            return false;
        }
        if(target == 0 ){
            return true;
        }

        if(dp[i][target] != -1){
            return dp[i][target] == 1  ? true : false ;
        }


        
        boolean inc = targetSumSubset(nums , i - 1,  target - nums[i] , dp);
        boolean exc = targetSumSubset(nums , i - 1,  target , dp );

        if(inc || exc){
            dp[i][target] = 1 ; 
        } else {
            dp[i][target] = 0 ; 
        }

        return inc || exc ;
    }


    public static void main(String args[]){
        int nums[] = {4 , 2 , 1 , 7 , 3} ;
        int target = 10 ;

        int dp[][] = new int[nums.length][target + 1] ;

        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ;  j <= target ; j++){
                dp[i][j] = -1 ;
            }
        }

        System.out.println(targetSumSubset( nums , nums.length - 1 ,  target , dp));
    }
}
