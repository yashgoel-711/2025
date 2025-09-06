package Stack;
import java.util.Stack;

public class StockSpan {

    static int[] findSpan(int prices[]){
        
        int span[] = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i = 1 ;  i < span.length ; i++){
            int curr = prices[i];
            while(!s.isEmpty() && curr >= prices[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            } else {
                span[i]  = i - s.peek() ;
            }
            s.push(i);
        }


        // span[0] = 1 ;
        // for(int i = 1 ; i < span.length ;i++){
        //     for(int j = i - 1 ; j>=0 ; j--){
        //         if(prices[j] > prices[i]){
        //             span[i] = i - j ;
        //             break;
        //         } else {
        //             span[i] = i + 1 ;
        //         }
        //     }
        // }

        return span;
    }

    public static void main(String args[]){
        int prices[] = {3,5,4,9,6,2,3,10};
        int[] span  = findSpan(prices);
        for(int i = 0 ; i < span.length ; i++){
            System.out.print(span[i] + " ");
        }
    }
}
