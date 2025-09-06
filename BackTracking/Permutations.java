package BackTracking;
// import java.util.Arrays;

public class Permutations {
    public static void perm(String s, String str){
        if(s.length() <= 0){
            System.out.println(str);
            return;
        }

        for(int i = 0 ; i < s.length() ; i++){
            String NStr = str + s.charAt(i);
            String NS = s.substring(0, i) + s.substring(i+1,s.length());
            perm(NS,NStr);
        }

    }
    public static void main(String args[]){
        String s = "abc";
        String str = "";
        perm(s,str);
    }
}
