package Trees.BST;

import java.util.ArrayList ;

public class CreateBST {
   
    static class Node{

        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 
    
    static class BinarySearchTree {
       
        Node createBST(Node root , int val){
            if(root == null){
                root = new Node(val);
                return root;
            }

            if(root.data < val){
               root.right =  createBST(root.right, val);
            }
            if(root.data > val){
               root.left = createBST(root.left, val);
            }
            return root;
        }
   
        void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
       
        void reverseInOrder(Node root){
            if(root == null){
                return ;
            }
            reverseInOrder(root.right);
            System.out.print(root.data + " ");
            reverseInOrder(root.left);
        }
   
        boolean search(Node root , int val){
            if(root == null){
                return false;
            }
            if(root.data == val){
                return true;
            }

            if(root.data < val){
                return search(root.right, val);
            }
            if(root.data > val){
                return search(root.left, val);
            }
            return false;
        }

        Node delete(Node root , int val){
            if(root.data > val){
                root.left = delete(root.left, val);
            } 
            else if(root.data < val){
                root.right = delete(root.right, val);
            } 
            else{
                //case 1 => 0 children
                if(root.left == null && root.right == null){
                    return null;
                }
                //case 2 => 1 children
                if(root.left == null){
                    root = root.right;
                
                }
                else if(root.right == null){
                    root = root.left;
                }
                //case 3 => 2 children
                else{
                    Node IS = InOrderSuccessor(root.right);
                    root.data = IS.data;
                    root.right = delete(root.right,IS.data);
                }
            }
            return root;
        }
    
        Node InOrderSuccessor(Node root){
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        void printInRange(Node root , int n1 , int n2){
            if(root == null){
                return;
            }
           

            if(root.data >= n1 && root.data <= n2){

                printInRange(root.left, n1, n2);
                System.out.print(root.data + " ");
                printInRange(root.right, n1, n2);           
            
            }
            else if(root.data > n2 ){
                printInRange(root.left, n1, n2);                
            }
            else{
                printInRange(root.right, n1, n2);                
            }

    }    

        void printPath(Node root , ArrayList<Node> path){
            if(root == null){
                return;
            }

            path.add(root);

            if(root.left == null && root.right == null){
                for(int i = 0 ; i < path.size() ; i++){
                    System.out.print(path.get(i).data + " ");
                }
                System.out.println();
            }

            else if(root.left == null){
                printPath(root.right, path);
            }
            else if(root.right == null) {
                printPath(root.left, path);
            }
            else{
                printPath(root.left, path);
                printPath(root.right, path);
            }
            path.remove(path.size()-1);

        }

    public static void main(String args[]){
        int values[] = {5,6,4,2,3,1,9};
        BinarySearchTree tree = new BinarySearchTree();
        Node root = null ;

        for(int i = 0 ; i < values.length ; i++){
            root  = tree.createBST(root, values[i]);
        }

        tree.inOrder(root);
        System.out.println();
        
        tree.reverseInOrder(root);
        System.out.println();

        ArrayList<Node> path = new ArrayList<>();
        tree.printPath(root, path);

    }

    }
}
