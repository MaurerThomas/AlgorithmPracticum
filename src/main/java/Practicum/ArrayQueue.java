package Practicum;

import java.util.NoSuchElementException;

/**
 * Created by Thomas on 9-12-2014.
 */
public class ArrayQueue<E> implements Queue<E> {

    private E[] elements;
    private int front;
    private int back;
    private static final int INITIAL_CAPICITY = 4;

    public ArrayQueue(){
        elements = (E[]) new Object[INITIAL_CAPICITY];
    }

    public ArrayQueue(int capacity){
        elements = (E[]) new Object[capacity];
    }


    @Override
    public void add(E element) {

        if (size() == elements.length - 1){
            resize();
        }
        elements[back] = element;
        if (back < elements.length - 1){
            ++back;
        } else {
            back = 0;
        }
    }

    @Override
    public E element() {
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return elements[front];
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public E remove() {
        if (size() == 0){
            throw new NoSuchElementException();
        }
        E element = elements[front];
        elements[front] = null;
        ++front;
        if (front == back){
            front = back = 0;
        }
        if (front == elements.length){
            front = 0;
        }
        return element;
    }

    @Override
    public int size() {
        if (front <= back){
            return back - front;
        } else {
            return back - front + elements.length;
        }
    }

    public String toString(){
        String out = "[";
        boolean first = true;
        for(int n=0; n < size();n++) {

            E e = elements[n];

            System.out.println("Arrayqueue " + e);
            if(!first) {
                out += ", ";
            }

            out += e.toString();
                first = false;

        }
        return out+"]";

    }

    private void resize(){
        int size = size();
        int len = elements.length;
        assert size == len;
        Object[] a = new Object[2*len];
        System.arraycopy(elements, front, a, 0, len - front);
        System.arraycopy(elements, 0, a, len - front, back);
        elements = (E[])a;
        front = 0;
        back = size;
    }

}
