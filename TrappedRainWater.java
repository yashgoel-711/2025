import java.util.Scanner;

public class TrappedRainWater{

    public static int TrappedWater(int arr[]){
        int trappedWater = 0;
        if(arr.length <= 2){
            return trappedWater;
        }        
        else{
            int leftMax[] = new int[arr.length];
            int rightMax[] = new int[arr.length];
            leftMax[0] = arr[0];
            rightMax[arr.length-1] = arr[arr.length-1];
            for(int i = 1 , j= arr.length-2 ; j >=0 ; j--,i++){
                leftMax[i] = Integer.max(arr[i], leftMax[i-1]);
                rightMax[j] = Integer.max(arr[j],rightMax[j+1]);
            }
           
            for(int i =1;i<=arr.length-2;i++){
                int leftBoundary = leftMax[i];
                int rightBoundary = rightMax[i];
                int level = Integer.min(leftBoundary, rightBoundary);
                int water =  (level - arr[i]);                   
                trappedWater += water;                
            }
        }
        return trappedWater;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        int trappedWater = TrappedWater(arr);
        System.out.println(trappedWater);
        sc.close();
    }
}