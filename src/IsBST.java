import java.util.ArrayList;

/**
 * The Node class creates node of the tree
 *
 * @author  Ravi Kumar Singh
 * @version 1.0
 * @since   2015-04-06
 */

class Node{

    int data;
    Node left;
    Node right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

/**
 * The BST class is to create the Binary search tree
 *
 * @author  Ravi Kumar Singh
 * @version 1.0
 * @since   2015-04-06
 */

public class IsBST {
    Node root;

    /**
     * insertNode to insert the Node to tree
     * @param key
     * @return void
     */
    public void insertNode(int key) {
        root = insertNode(root, new Node(key, null, null));
    }

    /**
     * insertNode to insert the Node to tree
     * @param currentParent, newNode
     * @return Node
     */
    public Node insertNode(Node currentParent, Node newNode) {

        if (currentParent == null) {
            return newNode;
        } else if (newNode.getData() > currentParent.getData()) {
            currentParent.right = insertNode(currentParent.right, newNode);
        } else if (newNode.getData() < currentParent.getData()) {
            currentParent.left = insertNode(currentParent.left, newNode);
        }
        return currentParent;
    }

    /**
     * inOrderTraversal to for inOrderTraversal for Tree
     * @param root
     * @return void
     */
    public void inOrderTraversal(Node root){
        if( root == null){
            return;
        }
        inOrderTraversal(root.getLeft());
        System.out.println(root.getData());
        inOrderTraversal(root.getRight());
    }

    public void isBSTInvalid(){
        if(isBSTInvalid(root)){
            System.out.println("Tree is BST");
        } else {
            System.out.println("Tree is not BST");
        }
    }

    private boolean isBSTInvalid(Node root) {
        if( root == null){
            return true;
        }

        if((root.getRight()!=null && root.getData() > root.getRight().getData()) || (root.getLeft()!=null && root.getData() < root.getLeft().getData())){
            return false;
        }
        if(isBSTInvalid(root.getLeft()) && isBSTInvalid(root.getRight())){
            return true;
        }
        return false;
    }

    public void isBSTValid(){

        if(isBSTvalid(root)){
            System.out.println("Tree is BST");
        } else {
            System.out.println("Tree is not BST");
        }
    }

    public void isBSTAnother(){
        if(isBSTAnother(root)){
            System.out.println("Tree is BST");
        } else {
            System.out.println("Tree is not BST");
        }
    }

    public void isBSTAnotherEfficient(){
        if(isBSTAnotherEfficient(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            System.out.println("Tree is BST");
        } else {
            System.out.println("Tree is not BST");
        }
    }

    private boolean isBSTAnotherEfficient(Node root, int minValue, int maxValue) {
        if( root == null){
            return true;
        }

        if( root.getData() < minValue || root.getData() > maxValue){
            return false;
        }
        return isBSTAnotherEfficient(root.getLeft(), minValue, root.getData()-1) && isBSTAnotherEfficient(root.getRight(), root.getData()+1, maxValue);
    }

    public void isBSTAnotherArray(){
        int count =0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        isBSTAnotherArray(root, list);
        for( int i= 0; i < list.size()-1 ;i++){
            System.out.println("the array" + list.get(i));
            if(list.get(i) > list.get(i+1)){
                count =1;
                System.out.println(" Its not BST");
            }
        }
        if( count ==0){
            System.out.println("Its BST");
        }

    }
    private boolean isBSTAnother(Node root) {
        Node prev =null;
        if( root==null ){
            return true;
        }
        isBSTAnother(root.getLeft());
        if( prev!=null && root.getData() < prev.getData() ){
            return false;
        }
        prev = root;
        System.out.println("prev " +prev.getData());
        return isBSTAnother(root.getRight());
    }

    private void isBSTAnotherArray(Node root, ArrayList<Integer> list) {
        if( root==null ){
            return;
        }
        isBSTAnotherArray(root.getLeft(), list);
        list.add(root.getData());
        isBSTAnotherArray(root.getRight(), list);
    }
    private boolean isBSTvalid(Node root) {

        if( root == null){
            return true;
        }
        if((root.getRight()!=null && root.getData() > findMinTheRightChild(root.getRight()).getData()) || (root.getLeft()!=null && root.getData() < findMaxTheLeftChild(root.getLeft()).getData())){
            return false;
        }
        if(isBSTInvalid(root.getLeft()) && isBSTInvalid(root.getRight())){
            return true;
        }
        return false;
    }

    private Node findMinTheRightChild(Node root) {
        if( root.getRight()==null && root.getLeft() ==null){
            return root;
        }
        return findMinTheRightChild(root.getLeft());
    }
    public  Node findMaxTheLeftChild(Node root){
        if( root.getRight()==null && root.getLeft() ==null){
            return root;
        }
        return findMaxTheLeftChild(root.getRight());
    }

    public static void main(String[] args) {
        IsBST tree = new IsBST();
        tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(70);
        tree.insertNode(60);
        tree.insertNode(80);
        System.out.println("in order travseal");
        tree.inOrderTraversal(tree.root);
        tree.isBSTInvalid();
        tree.isBSTValid();
        tree.isBSTAnother();
        tree.isBSTAnotherArray();
        tree.isBSTAnotherEfficient();
    }
}
