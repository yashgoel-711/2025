package Trees ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LCA2{

    public static class Node{
        int data;
        Node left;
        Node right ;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
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
            newNode.right = createTree(Nodes);
            return newNode;
        }

        Node lca2(Node root , int n1 , int n2){

            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            Node foundLeft = lca2(root.left, n1, n2);
            Node foundRight = lca2(root.right, n1, n2);

            if(foundLeft == null){
                return foundRight;
            }
            if(foundRight == null){
                return foundLeft;
            }
            return root;
        }
   
        boolean findPath(ArrayList<Node> path , int n , Node root){
            if(root == null){
                return false;
            }
            
            if(root.data == n){
                return true;
            }

            path.add(root);

            boolean foundLeft = findPath(path, n, root.left);
            boolean foundRight = findPath(path, n, root.right);
            
            if(!(foundLeft || foundRight)){
                path.remove(path.size() - 1);
                return false;
            }
            return true;

        }
       
        Node lca(Node root , int n1 , int n2){

            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            findPath(path1, n1, root);
            findPath(path2, n2, root);

            int i = 0;
            for( ; i < path1.size() && i < path2.size() ; i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }

            return path1.get(i-1);

        }
   
        static class Info {
            Node node;
            int level;
            Info(Node node , int level){
                this.node = node;
                this.level = level;
            }
        }
       
        void kthLevel(Node root , int k){

            Queue<Info> q = new LinkedList<>();
            q.add(new Info(root, 1));
            q.add(null);

            while(!q.isEmpty()){
                Info curr = q.remove();

                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    } else {
                        q.add(null);
                    }
                }
                else {
                    if(curr.level == k){
                        System.out.print(curr.node.data + " ");
                    } else {
                        if(curr.node.left != null){
                            q.add(new Info(curr.node.left , curr.level + 1));
                        }
                        if(curr.node.right != null){
                            q.add(new Info(curr.node.right , curr.level + 1));
                        }
                    }
                }
            }
        }
    
        int distance(Node root , int n){
            if(root == null ){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            int distanceLeft = distance(root.left, n);
            int distanceRight = distance(root.right, n);
            if(distanceLeft > -1){
                return 1 + distanceLeft;
            }
            if(distanceRight > -1){
                return 1 + distanceRight;
            }
           
            return -1;
            
        }
    
    }
    public static void main(String args[]){
        int Nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.createTree(Nodes);

        Node lca =tree.lca2(root, 5, 3);

      
        int minDistance = tree.distance(lca , 5) + tree.distance(lca , 3);
        System.out.println(minDistance);
       
    }
}