package LinkedList;

public class LLRevision {

    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node HEAD = null;
    static Node TAIL = null;
    static int size ;

    void add(int index , int data){

        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size){
            addLast(data);
            return;
        }

        Node newNode = new Node(data);

       int i = 1;
       Node temp = HEAD ;

       while(i < index){
        temp = temp.next;
        i++;
       }

       newNode.next = temp.next;
       temp.next = newNode;
        size++;
    }

    void addFirst(int data){

        Node newNode = new Node(data);

        if(HEAD == null){
            HEAD = TAIL = newNode ;
            size++;
            return;
        }

        newNode.next = HEAD;
        HEAD = newNode;
        size++;
    }

    void addLast(int data){
        if(HEAD == null){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        TAIL.next = newNode;
        TAIL= newNode;
        size++;
    }

    void print(){
        if(size == 0){
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
        int i = 1 ;
        Node temp = HEAD;
        while(i < size - 1){
            temp = temp.next;
            i++;
        }
        int value = TAIL.data;
        temp.next = null;
        TAIL = temp;
        size--;
        return value;
    }

    int remove(int index){

        if(index >= size){
            System.out.println("index is out of bounds");
            return Integer.MIN_VALUE;
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == size -1 ){
            return removeLast();
        }

        int i = 1 ;
        Node temp = HEAD;
        while(i < index){
            temp = temp.next;
            i++;
        }
        int value = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return value;

    }

    void reverse(){
        if(size == 0){
            System.out.println("LL is empty");
            return ;
        }
        if(size == 1){
            return;
        }
        TAIL = HEAD;
        Node prev = null;
        Node curr = HEAD;
        while(curr != null){
            Node Next = curr.next;
            curr.next= prev;
            prev = curr;
            curr = Next;
        }
        HEAD = prev;
    }

    int itrSearch(int element){
        int idx = 0;
        Node temp = HEAD;
        if(size ==0){
            System.out.println("LL is empty");
            return -1;
        }
        while(temp != null){
            if(temp.data == element){
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    int recSearch(Node HEAD , int element){
        if(size == 0){
            System.out.println("LL is empty");
            return -1;
        }
        if(HEAD.data == element){
            return 0;
        }
        if(HEAD.next == null || HEAD == null){
            return -1;
        }
        int idx = recSearch(HEAD.next, element) ;
        if(idx > -1){
            return 1 + idx;
        } else{
            return -1;
        }
    }

    boolean pallindrome(){
        if(size<=1){
            return false;
        }
        //mid 
        int mid = (size%2);
        Node temp = HEAD;
        int i =1;
        while (i < mid) {
            temp = temp.next;
            i++;
        }
        //2nd half
        Node THEAD = temp.next;
        temp.next = null;
        // reverse 2nd half
        Node prev = null;
        Node curr = THEAD;
        
        while(curr != null){
            Node Next  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        THEAD = prev;

        //check pallindrome
        temp = HEAD;
        while(temp != null && THEAD != null){
            if(temp.data != THEAD.data){
                return false;
            }
            temp = temp.next;
            THEAD  = THEAD.next;
        }
        return true;
    }

    boolean isCyclic(){
        Node slow = HEAD;
        Node fast = HEAD;

        if(size == 0){
            System.out.println("LL is empty");
            return false;
        }

        if(size == 1){
            if(fast.next.next == slow.next){
                return true;
            }
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;

    }
   
   void removeCycle(){
    if(!isCyclic()){
        return;
    }
    Node slow  = HEAD ;
    Node fast = HEAD ;
    slow = slow.next;
    fast = fast.next.next;

    while(slow != fast){
        slow = slow.next;
        fast = fast.next.next;
    }
    slow = HEAD;
    Node prev = fast;
    while(slow != fast){
        slow = slow.next;
        prev = fast;
        fast = fast.next;
    }
    prev.next = null;
    TAIL = prev;
   }

   Node getMid(Node THEAD){
    Node slow = THEAD;
    Node fast = THEAD.next ;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
   }

   Node mergeSort(Node THEAD){
    //base case
    if(THEAD == null || THEAD.next == null){
        return THEAD ;
    }
    //mid
    Node temp = getMid(THEAD);    
    //divide in 1st and 2nd half
    Node h1 = THEAD;
    Node h2 = temp.next;
    temp.next = null;
    //call mergeSort for both half's
    Node SortedLeft = mergeSort(h1);
    Node SortedRight = mergeSort(h2);
    //call merge
    return merge(SortedLeft , SortedRight);
   }

   Node merge(Node right , Node left){
    Node temp = new Node(-1);
    Node THEAD = temp;
    while(right !=null && left != null){
        if(right.data <= left.data){
            temp.next = right;
            temp = temp.next;
            right = right.next;
        } else{
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
    }
    if(right != null){
        temp.next = right;       
    } 
    if(left != null){
        temp.next = left;        
    }

    return THEAD.next;
   }

   public static void main(String args[]){
    LLRevision ll = new LLRevision();
    ll.addLast(5);
    ll.addLast(4);
    ll.addLast(3);
    ll.addLast(2);
    ll.addLast(1);
    ll.print();
    HEAD = ll.mergeSort(HEAD);
    ll.print();
    }
}
