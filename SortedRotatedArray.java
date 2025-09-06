public class SortedRotatedArray {
    public static int binSearch(int arr[],int si ,int ei , int ele){
        if(si > ei){
            return -1;
        }
        int mid = si + (ei - si)/2;
       
        if(ele == arr[mid]){
            return mid;
        }
        else if(ele < arr[mid]){
            binSearch(arr,si, mid -1 , ele);
        }
        else {
            binSearch(arr,mid + 1, ei, ele);
        }
        
    }
    public static void main(String args[]){
        int arr[] = {2,3,4,5,6,0,1};
        int ele = 1;
        int si = 0;
        int ei= arr.length -1;
            int mid = si + (ei-si)/2;
            if(ele == arr[mid]){
                System.out.println("found at : " + mid);
            }
            else if(ele < arr[mid]){


                if(ele == arr[si]){
                    System.out.println("found at : " + si);

                }
                 else if(ele > arr[si]){
                    System.out.println(binSearch(arr, si , mid , ele));    
                }
                else{
                    System.out.println( binSearch(arr , ei , mid , ele));
                   
                }


            }
            else {
                System.out.println(binSearch(arr, mid , ei,ele));
                
            }
        }
    
}
