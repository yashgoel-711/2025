public class Recursion {

    public static void recursion(String s ,int lp, int n ){

        if(n==0){
            System.out.println(s);           
            return;
        }
        
        recursion(s +"0",0, n-1);
        if(lp==0){
            recursion(s + "1",1,n-1);
        }

        


    }
    public static void main(String[] args){
        recursion("",0,3);
    }
}