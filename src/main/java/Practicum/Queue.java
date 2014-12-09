package Practicum;

/**
 * Created by Thomas on 4-12-2014.
 */
public interface Queue<E> {
    public void add(E element);
    public E element();
    public boolean isEmpty();
    public E remove();
    public int size();
}
