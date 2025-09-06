
import java.util.Stack;

public class IndianCoin{
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.add(1);
        s.add(2);
        s.add(5);
        s.add(10);
        s.add(20);
        s.add(50);
        s.add(100);
        s.add(200);
        s.add(500);
        s.add(1000);
        s.add(2000);

        int value = 2001;
        while(value > 0){
            
            while(!s.isEmpty() && value < s.peek()){
                s.pop();
            }
            System.out.print(s.peek() + " + ");
            value -= s.peek() ;
        }
    }
}