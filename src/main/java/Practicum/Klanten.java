package Practicum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Created by Thomas on 28-11-2014.
 */
public class Klanten implements BinaryTree, Comparator<Klanten.Node> {
    public Node root;
    protected int leeftijd;
    protected String achternaam;

    public Klanten() {


    }

    @Override
    public int compare(Node x, Node y) {
        if (x.value > y.value) {
            return 1;
        } else {
            return 0;
        }
    }

    public Klanten(int leeftijd,String achternaam){
        this.leeftijd = leeftijd;
        this.achternaam = achternaam;

    }

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Klanten[] klanten = new Klanten[4];
        klanten[0] = new Klanten(13,"maurer");
        klanten[1] = new Klanten(2,"levens");
        klanten[2] = new Klanten(15,"maurits");
        klanten[3] = new Klanten(5,"verker");


        int[] notSortedAge = {3, 2, 4, 5, 6, 1, 9, 10};
        sort(notSortedAge);

        String[] notSortedArray = {"maurer", "levens", "maurits", "verker"};
        // Search for lastname using linear Search
        System.out.println("Index: " + linearSearch(notSortedArray, "maurits"));

        String sortedArray[] = insertionSort(notSortedArray, notSortedArray.length);
        for (String aSortedArray : sortedArray) {
            System.out.println(aSortedArray);
        }

        // Binary Search
        System.out.println("Index: " + binarySearch(sortedArray, "maurer"));

        Klanten bst = new Klanten();
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(9);
        System.out.println("Inorder traversal");
        bst.printInorder();
        System.out.println("Removing customers 1 and 3");
        bst.remove(1);
        bst.remove(3);
        bst.printInorder();
        System.out.println("Sort with binary insertionsort");
        BinaryInsertionSort(notSortedArray);
    }

    /**
     * Insertion Sort
     */

    public static String[] insertionSort(String array[], int arrayLength) {
        String tempArray;
        for (int firstIndex = 0; firstIndex < arrayLength; firstIndex++) {
            for (int nextIndex = firstIndex + 1; nextIndex < arrayLength; nextIndex++) {

                // compareToIgnoreCase returns a negative integer, zero, or a positive integer as the specified String is greater than, equal to, or less than this String.
                if (array[firstIndex].compareToIgnoreCase(array[nextIndex]) > 0) {
                    tempArray = array[firstIndex];

                    array[firstIndex] = array[nextIndex];

                    array[nextIndex] = tempArray;

                }
            }
        }
        return array;
    }

    /**
     * LinearSearch
     */
    public static int linearSearch(String[] Achternamen, String achternaamInvoer) {
        for (int i = 0; i < Achternamen.length; i++) {
            if (Achternamen[i].equals(achternaamInvoer)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Merge Sort
     */
    public static void sort(int[] invoerArray) {
        sort(invoerArray, 0, invoerArray.length);
        System.out.println(Arrays.toString(invoerArray));
    }

    private static void sort(int[] invoerArray, int low, int high) {
        if (high - low < 2) {
            return;
        }
        int middle = (low + high) / 2;
        sort(invoerArray, low, middle);
        sort(invoerArray, middle, high);
        merge(invoerArray, low, middle, high);
    }

    private static void merge(int[] invoerArray, int low, int middle, int high) {
        if (invoerArray[middle - 1] <= invoerArray[middle]) {
            return;
        }
        int tijdelijkLow = low, tijdelijkMiddel = middle, beginPunt = 0;
        int[] tijdelijkeArray = new int[high - low];

        while (tijdelijkLow < middle && tijdelijkMiddel < high) {
            tijdelijkeArray[beginPunt++] = (invoerArray[tijdelijkLow] <= invoerArray[tijdelijkMiddel] ? invoerArray[tijdelijkLow++] : invoerArray[tijdelijkMiddel++]);
        }
        System.arraycopy(invoerArray, tijdelijkLow, invoerArray, low + beginPunt, middle - tijdelijkLow);
        System.arraycopy(tijdelijkeArray, 0, invoerArray, low, beginPunt);

    }

    /**
     * Binary Search
     */
    public static void BinaryInsertionSort (String[] words)
    {
        int ins, i, j;
        String tmp;

        for (i = 0; i < words.length; i++) {
            ins = binarySearch(words, words[i], 0, i);
            if (ins <= i) {
                tmp = words[i];
                for (j = i - 1; j >= ins; j--)
                    words[j + 1] = words[j];
                words[ins] = tmp;
                System.out.println(tmp);
            }
        }
    }
    public static int binarySearch(String[] words, String value) {
        return binarySearch(words, value, 0, words.length - 1);
    }

    private static int binarySearch(String[] words, String value, int start, int end) {
        if (start > end) {
            return -1;
        }
            //prevent int overflow
        int middle = ((end + start) / 2);

        if (words[middle].equals(value)) {
            return middle;
        } else if (words[middle].compareToIgnoreCase(value) > 0) {
            return binarySearch(words, value, start, middle - 1);
        } else {
            return binarySearch(words, value, middle + 1, end);
        }
    }

    @Override
    public void remove(int value) {
        root = remove(root, value);
    }

    private Node remove(Node latestRoot, int value) {
        Node node = new Node(value);
        int compareValue = compare(latestRoot, node);

        if (latestRoot == null) {
            // empty tree or value not found; nothing to do
        } else if (compareValue > 1) {
            // value is in my right subtree, if it is in the tree at all; go right
            latestRoot.right = remove(latestRoot.right, value);
        } else if (compareValue < 0) {
            // value is in my left subtree, if it is in the tree at all; go left
            latestRoot.left = remove(latestRoot.left, value);
        } else {
            // node.data == value; this node is the node to remove
            if (latestRoot.left == null && latestRoot.right == null) {
                // case 1: leaf; replace with null
                latestRoot = null;
            } else if (latestRoot.right == null) {
                // case 2: left child only; replace with left child
                latestRoot = latestRoot.left;
            } else if (latestRoot.left == null) {
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

    @Override
    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        insertRec(root, node);
    }

    private void insertRec(Node latestRoot, Node nextNode) {
        int value = compare(latestRoot, nextNode);

        if (value >= 1) {
            if (latestRoot.left == null) {
                latestRoot.left = nextNode;
                return;
            } else {
                insertRec(latestRoot.left, nextNode);
            }
        } else {
            if (latestRoot.right == null) {
                latestRoot.right = nextNode;
                return;
            } else {
                insertRec(latestRoot.right, nextNode);
            }
        }
    }

    @Override
    public void printInorder() {
        printInOrderRec(root);
        System.out.println("");
    }

    private void printInOrderRec(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        printInOrderRec(currRoot.left);
        System.out.print(currRoot.value + ", ");
        printInOrderRec(currRoot.right);
    }

    @Override
    public void printSearch() {
        search(root, 5);
        System.out.println("");
    }

    @Override
    public boolean search(Node node, int value)
    {
        if (node == null)
        {
            return false;
        }
        else if (node.value == value)
        {
            return true;
        }
        else
        {
            if (value < node.value)
            {
                return search(node.left, value);
            }
            else
            {
                return search(node.right, value);
            }
        }
    }
}


