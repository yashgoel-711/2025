package BackTracking;

public class Subsets {

    public static void recursion(char s[] , String subset , int i){
        if(i >= s.length){
            System.out.println(subset);
            return;
        }
        recursion(s, subset + s[i], i+1);
        recursion(s, subset, i+1);
    }
    public static void main(String args[]){
        char s[] = {'a','b','c'};
        String subset = "";
        recursion(s,subset,0);
    }
}
