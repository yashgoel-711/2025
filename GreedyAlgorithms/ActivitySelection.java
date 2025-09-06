

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //sorting on the basis of minimum ending time
        int activities[][] = new int[start.length][3];
        for(int i = 0 ; i < start.length ; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        //using lamda function
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2]));

        //initiazling count and order arraylist to track order of activities performed
        int count = 0 ;
        ArrayList<Integer> order = new ArrayList<>();

        //adding 1st activity with minimum ending time
        order.add(activities[0][0]);
        count++;
        int lastEnd = activities[0][2];

        //adding non-overlapping activities with minimum ending time
        for(int i = 1 ; i < activities.length ; i++){
            if(activities[i][1] >= lastEnd){
                order.add(activities[i][0]);
                lastEnd = activities[i][2];
                count++;
            }
        }

        //printing the order and count
        System.out.println(count);
        for(int i = 0 ; i < order.size() ; i++){
            System.out.print("A" + order.get(i) + " ");
        }
    }
}
