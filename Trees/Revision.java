package Trees;

public class Revision {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
   
    static class BinaryTrees{

        static int index = -1;
        Node createBinaryTree(int Nodes[]){
            
            index++;
            if(index >= Nodes.length || Nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(Nodes[index]);
            newNode.left = createBinaryTree(Nodes);
            newNode.right = createBinaryTree(Nodes);
            return newNode;
        }
    
        void PreOrderTraversal(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.val + " ");
            PreOrderTraversal(root.left);
            PreOrderTraversal(root.right);

        }
        
        void PostOrderTraversal(Node root){
            if(root == null){
              
                return;
            }
            PostOrderTraversal(root.left);
            PostOrderTraversal(root.right);
            System.out.print(root.val + " ");

        }
       
        void InOrderTraversal(Node root){
            if(root == null){
               
                return;
            }
            InOrderTraversal(root.left);
            System.out.print(root.val + " ");
            InOrderTraversal(root.right);

        }
    }
    
    
    public static void main(String args[]){

        int Nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTrees tree = new BinaryTrees();
        Node root = tree.createBinaryTree(Nodes);
        tree.PreOrderTraversal(root);
        
    }
}
