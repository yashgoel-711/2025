

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String args[]){

        int price[] = {60 , 100 , 120};
        int weigth[] = {10 , 20 , 30};
        int capacity = 50 ;
        int money = 0;

        ArrayList<Integer> sackNumber = new ArrayList<>();
        ArrayList<Integer> sackWeigth = new ArrayList<>();

        //made ratio 2d array to track sack number and price per unit weigth of that particular sack
        int ratio[][] = new int[weigth.length][2];
        for(int i = 0 ; i<weigth.length ; i++){
            ratio[i][0] = i;
            ratio[i][1] = price[i] / weigth[i] ;
        }

       //sorted according to price per unit weigth
        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));

        //adding sacks with maximum price per unit weigth first until the holding capacity becomes 0
        for(int i = ratio.length - 1 ; i >= 0 ; i--){
            if(weigth[ratio[i][0]] <= capacity){
                capacity = capacity - weigth[ratio[i][0]] ;
                money += price[ratio[i][0]];
                sackNumber.add(ratio[i][0]);
                sackWeigth.add(weigth[ratio[i][0]]);
            } else {
                money += ratio[i][1] * capacity ;
                sackNumber.add(ratio[i][0]);
                sackWeigth.add(capacity);
                capacity = 0 ;
                break;
            }

        }

        System.out.println(money);
        for(int i = 0 ; i < sackNumber.size() ; i++){
            System.out.println("sack" + sackNumber.get(i) +" -> " + sackWeigth.get(i) + "kg");
        }
    }
}
