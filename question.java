public class question{

    public static String update(String s){
        StringBuilder s2 = new StringBuilder();
        
        for(String s1 : s.split(" ")){
            s2.append(s1.toUpperCase() + " ");
        }
        return s2.toString();
    }
    public static void main(String args[]){
        System.out.println(update("utkarsh is a good boy"));
    }
}
