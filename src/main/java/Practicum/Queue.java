package Practicum;

/**
 * Created by Thomas on 4-12-2014.
 */
public interface Queue<T> {
    Queue<T> enqueue(T ele);
    T dequeue();
    T update();
}
