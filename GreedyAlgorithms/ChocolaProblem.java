import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem{
    public static void main(String args[]){
        Integer vc[] = {2,1,3,1,4} ;
        Integer hc[] = {4,1,2} ;

        Arrays.sort(vc , Collections.reverseOrder());
        Arrays.sort(hc , Collections.reverseOrder());

        int hp =1;
        int vp =1;
        int cost = 0;
        int i = 0 , j =0 ;
        while(i<vc.length && j < hc.length){
            if(vc[i] > hc[j]){
                cost = cost + (vc[i] * hp) ;
                vp++;
                i++;
            } else {
                cost = cost + (hc[j] * vp) ;
                hp++;
                j++;
            }

        }
        while(i < vc.length){
            cost = cost + (vc[i] * hp) ;
                vp++;
                i++;
        }
        while(j < hc.length){
             cost = cost + (hc[j] * vp) ;
                hp++;
                j++;
        }

        System.out.println(cost);

    }
}