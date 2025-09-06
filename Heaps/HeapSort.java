package Heaps;

public class HeapSort {

    public static void heapify(int arr[], int i , int size){
        int parent = i;
        int left = parent *2 + 1;
        int right = parent *2 + 2;
        int maxIndex = parent;

        if(left < size && arr[left] > arr[maxIndex]){
            maxIndex = left;
        }
        if(right < size && arr[right] > arr[maxIndex]){
            maxIndex = right;
        }
        if(maxIndex != parent){
            int temp = arr[parent];
            arr[parent] = arr[maxIndex];
            arr[maxIndex] = temp;
            heapify(arr, maxIndex, size);
        }
    }

    public static void heapSort(int[] arr){
        for(int i = arr.length / 2 ; i >=0 ; i--){
            heapify(arr, i, arr.length);
        }
        int n = arr.length - 1;
        while(n > 0){
            int temp = arr[n];
            arr[n] = arr[0];
            arr[0] = temp;

            heapify(arr, 0 , n);
            n--;

        }

    }
    
    public static void main(String args[]){
        int arr[] = {10,9,8,7,6,5,4,3,2,1};
        heapSort(arr);
        for(int n : arr){
            System.out.print(n + " ");
        }
    }
    
}
