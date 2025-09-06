package Stack;
import java.util.Stack;

class ValidParenthesis {
    
    static boolean check(String str){
        Stack<Character> s = new Stack<>();
        s.push(str.charAt(0));

        for(int i = 1 ; i < str.length() ; i++){
            char temp = str.charAt(i) ;
            if((temp == ')' && s.peek() == '(') || (temp == ']' && s.peek() == '[') || (temp == '}' && s.peek() == '{')){
                s.pop();
            } else {
                s.push(temp);
            }
        }        


        if(s.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String args[]){
        String str = "[({()})]";
        System.out.println(check(str));
    }
}