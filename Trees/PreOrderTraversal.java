package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTraversal{

    public static class Node {
        int data;
        Node left;
        Node rigth;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.rigth = null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;

        Node createTree(int Nodes[]){
            idx++;
            if(Nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = createTree(Nodes);
            newNode.rigth = createTree(Nodes);
            return newNode;
        }
   
        void preOrderTraverse(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return ;
            }
            System.out.print(root.data + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.rigth);
        }
    
        void InOrderTraverse(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }
            InOrderTraverse(root.left);
            System.out.print(root.data + " ");
            InOrderTraverse(root.rigth);
        }
    
        void postOrderTraverse(Node root){
            if(root == null){
                System.out.print(-1 + " ");
                return;
            }
            postOrderTraverse(root.left);
            postOrderTraverse(root.rigth);
            System.out.print(root.data + " ");
        }
    
        void levelOrderTraverse(Node root) {
            if(root == null){
                return ;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    if(q.isEmpty()){
                        System.out.println();
                        break;
                    } else {
                        System.out.println();
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    } 
                    if(currNode.rigth != null){
                        q.add(currNode.rigth);
                    } 
                }
            }

        }

        int heigth(Node root){
            if(root == null){
                return 0;
            }
            int leftSubTreeHeigth = heigth(root.left);
            int rigthSubTreeHeigth = heigth(root.rigth);
            return 1 + Math.max(leftSubTreeHeigth , rigthSubTreeHeigth);
        }
    
        int numberOfNodes(Node root){
            if(root == null){
                return 0 ;
            }
            return 1 + numberOfNodes(root.left) + numberOfNodes(root.rigth);
        }
    
        int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            return root.data + sumOfNodes(root.left) + sumOfNodes(root.rigth);
        }
        
        static class Info{
            int diameter;
            int heigth;
            Info(int diameter , int heigth){
                this.diameter = diameter;
                this.heigth = heigth;
            }
        }
       
        Info diameter(Node root){

            if(root == null) {
                Info i = new Info(0, 0) ;
                return i;
            }
            Info leftSubTreeInfo = diameter(root.left);
            Info rigthSubTreeInfo = diameter(root.rigth);

            int leftSubTreeHeigth = leftSubTreeInfo.heigth;
            int rigthSubTreeHeigth = rigthSubTreeInfo.heigth;

            int d = leftSubTreeHeigth + rigthSubTreeHeigth + 1 ;
            int leftDiameter = leftSubTreeInfo.diameter;
            int rigthDiameter = rigthSubTreeInfo.diameter;

            Info i = new Info(Math.max(d ,Math.max(rigthDiameter, leftDiameter)), Math.max(rigthSubTreeHeigth, leftSubTreeHeigth) + 1);
            return i ;
        }
    }

    public static void main(String args[]){
        int Nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.createTree(Nodes);

       
        
       System.out.println(tree.diameter(root).diameter);

    }
}