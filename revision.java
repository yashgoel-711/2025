import java.util.Scanner;

public class revision{

    public static void quesions(int arr[]){
       int max = Integer.MIN_VALUE;
       int min = Integer.MAX_VALUE;
        for(int i =0 ; i <arr.length  ; i++){
            if(arr[i]>max){
                max=arr[i];
            }
            else if (arr[i] < min){
                min = arr[i];
            }            
        }
        if(min > 0){
            min = 0;
        }
        System.out.println(max);
        System.out.println(min);
        int sorted[] = new int[max - min + 1];
        for(int i = 0 ; i < arr.length ; i++){
            sorted[(arr[i])-min]++ ;
        }
        for(int i = 0 ; i < sorted.length ; i++){
            int count = sorted[i];
            while(count > 0 ){
                System.out.print((i+min)+" ");
                count--;
            }
        }




        // for(int i = 0 ; i < arr.length ; i++){
        //     System.out.print(arr[i] + " ");
        // }

    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        quesions(arr);
        sc.close();
    }
}