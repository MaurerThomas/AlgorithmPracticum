package Practicum;



public class BinTree {
    public Node root;

    public static void main(String[] args) {
        BinTree bst = new BinTree();

        bst.insert(40);
        bst.insert(43);
        bst.insert(48);
        bst.insert(49);
        bst.insert(94);
        bst.insert(23);
        bst.insert(12);

        System.out.println("Inorder traversal");
        bst.printInorder();

    }

    public void insert(int value){
        Node node = new Node<>(value);

        if ( root == null ) {
            root = node;
            return;
        }

        insertRec(root, node);

    }



    private void insertRec(Node latestRoot, Node node){

        if ( latestRoot.value > node.value){

            if ( latestRoot.left == null ){
                latestRoot.left = node;
                return;
            }
            else{
                insertRec(latestRoot.left, node);
            }
        }
        else{
            if (latestRoot.right == null){
                latestRoot.right = node;
                return;
            }
            else{
                insertRec(latestRoot.right, node);
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