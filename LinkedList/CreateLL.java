package LinkedList;

public class CreateLL {

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    static int size ;
    static Node HEAD = null ;
    static Node TAIL = null ;

    void addFirst(int data){
        Node newNode = new Node(data);
        if(HEAD == null){
            HEAD = TAIL = newNode;
            size++;
            return;
        }

        newNode.next = HEAD;        
        HEAD = newNode;
        size++;
    }

    void addLast(int data){
        Node newNode = new Node(data);
        if(HEAD == null){
            HEAD = TAIL = newNode;
            return;
        }

        TAIL.next = newNode;
        TAIL = newNode;
        size++;
    }

    void add(int index , int data){
        if(index ==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);

        Node temp = HEAD;
        int i = 1;
        while(i<index){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    void print(){
        if(HEAD == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = HEAD;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    int removeFirst(){

        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int value = HEAD.data;
            HEAD = TAIL = null ;
            size = 0 ;
            return value;
        }

        int value = HEAD.data;
        HEAD = HEAD.next;
        size--;
        return value;
    }

    int removeLast(){

        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
          if(size == 1){
            int value = HEAD.data;
            HEAD = TAIL = null ;
            size = 0;
            return value;
        }

        Node prev = HEAD;
        for(int i = 1 ; i < size - 1 ; i++){
            prev = prev.next;
        }
        
        int value = TAIL.data;
        prev.next = null;
        TAIL = prev;
        size--;
        return value;
    }

    void reverse(){ 

        Node prev = null;
        Node curr = HEAD ;
        TAIL = curr;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        HEAD = prev;

    }

    int itrSearch(int element){

        Node temp = HEAD ;
        int i =0;
        while(temp != null){
            if(temp.data == element){
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
  
    int recSearch(Node head , int element){
        if(head == null){
            return -1;
        }
        if(head.data == element){
            return 0;
        }
        int indx = recSearch(head.next, element);
        if( indx >-1){
            return indx + 1;
        }
        else{
            return -1;
        }
    }
  
    int removeIthFromLast(int indx){
        if(indx == 1){
            return removeLast() ;
        }

        if(indx == size){
            
            return removeFirst();
        }

        int n = size - indx + 1;        
        Node prev = HEAD;
        int i = 1;

        while(i < n - 1 ){
            prev = prev.next;
            i++;
        }
        int value = prev.next.data;
        prev.next = prev.next.next;
        return value;
    }
    public static void main(String[] args){
        CreateLL ll = new CreateLL();
        

        // ll.print();
        ll.addFirst(2);
        // ll.print();
        ll.addFirst(1);
        // ll.print();
        ll.addLast(3);
        // ll.print();
        ll.addLast(4);
        // ll.print();
        
        ll.add(0,5);
        // ll.print();
        ll.add(4,6);
        ll.print();
        // System.out.println(size);

        // ll.removeLast();
        // ll.print();
        // System.out.println(size);
        
        // ll.removeFirst();
        // ll.print();
        // System.out.println(size);

        // ll.reverse();
        // ll.print();

        // System.out.println(ll.itrSearch(10));
        // System.out.println(ll.recSearch(HEAD,10));

        // System.out.println(ll.removeIthFromLast(6));
        // ll.print();

        
    }

}
