package Stack;
import java.util.Stack;

public class ReverseStack {

    static void pushAtBottom(int element , Stack<Integer> s){
        if(s.isEmpty()){
            s.push(element);
            return;
        }
        int temp = s.pop();
        pushAtBottom(element, s);
        s.push(temp);
    }

    static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int temp = s.pop();
        reverse(s);
        pushAtBottom(temp, s);
    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}
