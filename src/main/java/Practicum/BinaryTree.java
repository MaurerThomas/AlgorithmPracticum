package Practicum;

/**
 * Created by Thomas on 12-1-2015.
 */
public interface BinaryTree<E> {
    public void insert(int value);
    public void remove(int value);
    public void printInorder();
    public boolean search(Klanten.Node node, int value);
    public void printSearch();
}
