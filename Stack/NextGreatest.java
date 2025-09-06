package Stack;
import java.util.Stack;

public class NextGreatest {

    static void findNG(int prices[] , int NG[]){
        Stack<Integer> s = new Stack<>();        
        int i = NG.length - 1;
        s.push(i);
        NG[i] = -1;
        i--;
        for(; i >= 0 ; i--){
            while(!s.isEmpty() && prices[i] >= prices[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                NG[i] = -1 ;
            } else {
                NG[i] = s.peek();
            }
            s.push(i);
        }
    }

    public static void main(String args[]){
        int prices[] = {3,5,4,9,6,2,3,10};
        int NG[] = new int[prices.length];
        findNG(prices, NG);
        for(int i = 0 ; i< NG.length ; i++){
            System.out.print(NG[i] + " ");
        }
    }
}
