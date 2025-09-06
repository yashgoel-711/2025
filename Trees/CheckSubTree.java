package Trees;

public class CheckSubTree {
   
    static class Node {
        int data;
        Node left;
        Node rigth;

        Node(int data){
            this.data =data;
            this.left = null;
            this.rigth = null;
        }
    }
   
   static class BinaryTree{

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
   }

   static Node search(Node root , Node subTreeRoot){
    if(root == null){
        return null;
    }
    if(root.data == subTreeRoot.data){
        return root;
    } 
        Node leftResult = search(root.left, subTreeRoot);
        Node rigthResult = search(root.rigth, subTreeRoot);
        
        if(leftResult != null){
            return leftResult;
        } 
        else if(rigthResult != null){
            return rigthResult;
        }
        else{
            return null;
        }

   }
  
   static boolean checkSubTree(Node root ,Node subTreeRoot){
    root = search(root, subTreeRoot) ;
    if(root == null){
        return false;
    }
    else {
        return check(root, subTreeRoot);
    }
   }
  
   static boolean check(Node root , Node subTreeRoot){
    if(root == null && subTreeRoot == null){
        return true;
    }
    else if(root == null || subTreeRoot == null){
        return false;
    }
    else if(root.data != subTreeRoot.data){
        return false;
    }
    else{
        return check(root.left, subTreeRoot.left) && check(root.rigth, subTreeRoot.rigth) ;
    }
  }
  
   public static void main(String args[]){

    int Nodes1[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    int Nodes2[] = {2,4,-1,-1,5,-1,-1};

    BinaryTree tree1 = new BinaryTree();
    Node root = tree1.createTree(Nodes1);
    BinaryTree.idx = -1;
    BinaryTree tree2 = new BinaryTree();
    Node SubTreeRoot = tree2.createTree(Nodes2);

    System.out.println(checkSubTree(root, SubTreeRoot));
    }
}
