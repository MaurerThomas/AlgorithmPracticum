package Practicum;

public class BinTree<E>  {
    public Node root;

    public class Node<E> {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }


    public static void main(String[] args) {
        BinTree bst = new BinTree();

        bst.insert(40);
        bst.insert(43);
        bst.insert(48);
        bst.insert(49);
        bst.insert(94);
        bst.insert(23);
        bst.insert(12);
        bst.remove(12);


        System.out.println("Inorder traversal");
        bst.printInorder();

    }

    public void remove(int value) {
        root = remove(root, value);
    }

    private Node remove(Node latestRoot, int value){

        if (latestRoot == null){
            // empty tree or value not found; nothing to do
        }else if (latestRoot.value < value){
            // value is in my right subtree, if it is in the tree at all; go right
            latestRoot.right = remove(latestRoot.right,value);
        } else if (latestRoot.value > value){
            // value is in my left subtree, if it is in the tree at all; go left
            latestRoot.left = remove(latestRoot.left,value);
        } else {
            // node.data == value; this node is the node to remove
            if (latestRoot.left == null && latestRoot.right == null){
                // case 1: leaf; replace with null
                latestRoot = null;
            } else if (latestRoot.right == null){
                // case 2: left child only; replace with left child
                latestRoot = latestRoot.left;
            } else if (latestRoot.left == null){
                // case 3: right child only; replace with right child
                latestRoot = latestRoot.right;
            } else {
                // case 4: both children; replace with minimum value from right subtree
                int min = getMin(latestRoot.right);
                latestRoot.right = remove(latestRoot.right, min);
                latestRoot.value = min;
            }
        }
        return latestRoot;
    }

    // Helper to return the smallest value in the given part of the tree.
    private int getMin(Node node) {
        if (node.left == null) {
            // no left child, so this must be the leftmost (min) node
            return node.value;
        } else {
            // I have a left child, so he must be smaller than me; go to the left
            return getMin(node.left);
        }
    }


    public void insert(int value){
        Node node = new Node<>(value);
        if ( root == null ) {
            root = node;
            return;
        }
        insertRec(root, node);

    }

    private void insertRec(Node latestRoot, Node nextNode){

       if ( latestRoot.value > nextNode.value){

            if ( latestRoot.left == null ){
                latestRoot.left = nextNode;
                return;
            }
            else{
                insertRec(latestRoot.left, nextNode);
            }
        }
        else{
            if (latestRoot.right == null){
                latestRoot.right = nextNode;
                return;
            }
            else{
                insertRec(latestRoot.right, nextNode);
            }
        }
    }
        /**
         * Printing the contents of the tree in an inorder way.
         */
    public void printInorder(){
        printInOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in an inorder way
     */
    private void printInOrderRec(Node currRoot){
        if ( currRoot == null ){
            return;
        }
        printInOrderRec(currRoot.left);
        System.out.print(currRoot.value+", ");
        printInOrderRec(currRoot.right);
    }



}