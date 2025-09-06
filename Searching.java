import java.util.Arrays;

public class Searching {
    public static int linear(int[] arr , int i , int value){
        if(i >= arr.length){
            return -1;
        }
        if(arr[i] == value){
            return i;
        }

        return linear(arr ,  i + 1 ,  value);
    }

    
    public static int binaryUtil(int[] arr , int value , int l , int r){
        if(l>r){
            return -1;
        }
        int mid = (l + r) / 2;
        if( value > arr[mid]  ){
           return  binaryUtil( arr ,  value ,  mid + 1 ,  r);
        } else if (value < arr[mid]){
           return binaryUtil( arr ,  value ,  l ,  mid - 1);
        } 
        return mid ;
    }
   
    public static int binary(int[] arr , int value){
        Arrays.sort(arr);
        return binaryUtil(arr, value ,0 , arr.length - 1);
    }

    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6} ;
        System.out.println(binary(arr,  5));
    }
}
