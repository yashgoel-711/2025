package Stack;
import java.util.Stack;

public class PushAtBottom {
    
    static void pushAtBottom(int element , Stack<Integer> s){
        if(s.isEmpty()){
            s.push(element);
            return ;
        }
        int temp = s.pop();
        pushAtBottom(element, s);
        s.push(temp);
    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(4, s);
        System.out.println(s);
    }
}
