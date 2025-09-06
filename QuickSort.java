public class QuickSort{
    public static void quickSort(int arr[], int si , int ei){
        if(si >= ei){
            return;
        }
        int pivot = si + (ei-si)/2; 
        int pivotind = partition(arr , si ,ei , pivot);
        quickSort(arr, si, pivotind - 1);
        quickSort(arr,pivotind+1 , ei);
    }

    public static int partition(int arr[] , int si , int ei,int pivot ){
        int i = si-1;
        int j = si;
        while(j < ei){
            if(arr[j] < arr[pivot]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
            j++;
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] =temp;

        return i;
    }
    public static void main(String args[]){
        int arr[] = {-2,3,4,1,0,5};
        quickSort(arr , 0 , arr.length -1);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}