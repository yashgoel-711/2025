package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class ViewOfTree {

    public static class Node {
        Node left;
        Node rigth;
        int data;

        Node(int data){
            this.data = data;
            this.left = null;
            this.rigth = null;
        }
    }

    public static class Info{
        Node node;
        int hd;

        Info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    
    static class BinaryTree{

        static int idx = -1;
        Node createBinaryTree(int Nodes[]){
            idx++;
    
            if(Nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
    
            newNode.left = createBinaryTree(Nodes);
            newNode.rigth = createBinaryTree(Nodes);
            return newNode;
        }

        void topView(Node root){
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer , Node > map = new HashMap<>();

            int min = 0 , max = 0 ;

            q.add(new Info(root , 0));
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
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.node);
                    }

                    if(curr.node.left != null){
                        q.add(new Info(curr.node.left, curr.hd - 1));
                        min = Math.min(min , curr.hd -1 );
                    }

                    if(curr.node.rigth != null){
                        q.add(new Info(curr.node.rigth, curr.hd + 1));
                        max = Math.max(max , curr.hd + 1);
                    }
                }
            }

            for(int i = min ; i <= max ; i++){
                System.out.print(map.get(i).data + " ");
            }
        }
    }
    public static void main(String args[]){
        int Nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.createBinaryTree(Nodes);

        tree.topView(root);
    }

}
