package Stack;
import java.util.Stack;

public class DuplicateParenthesis {

    static boolean check(String str){
        Stack<Character> s = new Stack<>();

        s.push(str.charAt(0));

        for(int i = 1; i < str.length(); i++){
            char temp = str.charAt(i);
            int count = 0;
            if(temp == ')' || temp == ']' || temp == '}'){
            while(true){
                if(s.peek()=='(' || s.peek() == '[' || s.peek() == '{'){
                    if(count < 1){
                        return true;
                    } else {
                        s.pop();
                        break;
                    }
                } else {
                    s.pop();
                    count++;
                }
            }
        } else {
            s.push(temp);
        }

    }

        return false;
    }
    public static void main(String args[]){
        String str = "(((a+b)+(a-b)))" ;
        System.out.println(check(str));
    }
}
