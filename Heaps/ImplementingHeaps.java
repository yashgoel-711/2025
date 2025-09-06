package Heaps;
import java.util.ArrayList;

public class ImplementingHeaps {
    
    public static class Heap{
        ArrayList<Integer> list ;
        Heap(){
            this.list = new ArrayList<>();
        }

        void add(int n){
            list.add(n);
            int child = list.size() - 1;
            int parent = (child - 1)/2 ;

            while(parent >= 0 && list.get(parent) > list.get(child)){
                int temp = list.get(child);
                list.set(child , list.get(parent));
                list.set(parent , temp);

                child = parent ;
                parent = (child - 1)/2 ;
            }
        }
   
        int peek(){            
            return list.get(0);
        }
    
        boolean isEmpty(){
            return list.size() == 0 ? true : false ;
        }
    
        void heapify(int i){
            int parent = i;
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            int minIndex = parent ;

            
            if(left < list.size() && list.get(left) < list.get(minIndex)){
                minIndex = left;
            } 
            if(right < list.size() && list.get(right) < list.get(minIndex)){
                minIndex = right;
            } 
            if(minIndex != parent){
                int t = list.get(parent);
                list.set(parent , list.get(minIndex));
                list.set(minIndex , t);
                heapify(minIndex);
            }
            
       }
       
        int remove(){
            int data = list.get(0);
            
            int temp = list.get(list.size() - 1);
            list.set(0 , temp);
            list.remove(list.size() - 1) ;

            heapify(0);

            return data;
        }
        
          
    }

    public static void main(String args[]){
        Heap pq = new Heap();
        pq.add(5);
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(2);       

        while(!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }
}
