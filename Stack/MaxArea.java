package Stack;
import java.util.Stack;

public class MaxArea {

    public static int[] LeftSmaller(int heigth[]){
        int LS[] = new int[heigth.length];
        Stack<Integer> s = new Stack<>();
        int i = 0 ;
        LS[0] = -1;
        s.push(0);
        for( i = 1 ; i < heigth.length ; i++){
            int curr = heigth[i];
            while(!s.isEmpty() && curr <= heigth[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                LS[i] = -1;
                s.push(i);
            } else {
                LS[i] = s.peek();
                s.push(i); 
            }
        }
        return LS;
    }

    public static int[] RigthSmaller(int height[]){
        int RS[] = new int[height.length];
        Stack<Integer> s = new Stack<>();
        int i = height.length - 1 ;
        RS[i] = height.length ;
        s.push(i);
        for( i = height.length - 2 ; i>=0 ; i--){
            int curr = height[i];
            while(!s.isEmpty() && curr <= height[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                RS[i] = height.length ;
                s.push(i);
            } else {
                RS[i] = s.peek();
                s.push(i);
            }
        }
        return RS;
    }
   
    public static int maxArea(int heigth[]){
        int area = 0 ;
        int LS[] = LeftSmaller(heigth);
        int RS[] = RigthSmaller(heigth);
        for(int i = 0 ; i < heigth.length ; i++){
            int width = RS[i] - LS[i] - 1;
            int temp = heigth[i] * width ;
            if(temp > area){
                area =temp;
            }
        }
        return area;
    }
    public static void main(String args[]){
        int heigth[] = {2,3,1,4,3,2,3};
        System.out.println(maxArea(heigth));
    }
}
