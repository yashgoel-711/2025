package DP;

public class _01KnapSack {

    public static int recursive(int[] cost , int[] weight , int i , int space  , int dp[][]  ){
        if(space == 0 || i >= cost.length){
            return 0;
        }
        if(dp[i][space] != -1){
            return dp[i][space] ;
        }

        int p1 = 0;
        if(space - weight[i] >= 0){
            p1 =  cost[i] +  recursive(cost ,  weight ,  i + 1 ,  space - weight[i]   , dp );
        }
        int p2 =  recursive(cost ,  weight ,  i + 1 ,  space , dp );

        dp[i][space] =  Math.max(p1 , p2) ;
        return dp[i][space] ;
    } 
   
   
    public static void main(String args[]){
        int[] cost = {15, 14 , 10 , 45 ,30};
        int[] weight = {2 , 5 , 1 , 3 , 4};
        int space = 7 ;

        int dp[][] = new int[cost.length][space + 1] ;
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[i].length ; j++){
                dp[i][j] = -1 ;
            }
        }

        
        System.out.println(recursive(cost ,  weight , 0 ,  space  , dp  ));
    }
}
