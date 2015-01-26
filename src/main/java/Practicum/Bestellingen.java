package Practicum;

import java.sql.Date;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Created by Thomas on 1-12-2014.
 */
public class Bestellingen<T> implements Queue<T>{

    private int total;
    private Node first, last;
    protected int klantID;
    protected int bestellingID;
    protected boolean verwerking;
    protected int startTijd;
    protected int duur;
    protected boolean compleet;
    protected boolean dadelijk;

    // setters
    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }
    public void setBestellingID(int bestellingID) {
        this.bestellingID = bestellingID;
    }
    public void setVerwerking(boolean verwerking) {
        this.verwerking = verwerking;
    }
    public void setStartTijd(int startTijd) {
        this.startTijd = startTijd;
    }
    public void setDuur(int duur) {
        this.duur = duur;
    }
    public void setCompleet(boolean compleet) {
        this.compleet = compleet;
    }
    public void setDadelijk(boolean dadelijk) {
        this.dadelijk = dadelijk;
    }

    public Bestellingen(){
        first = null;
        last = null;
        total = 0;
    }


    public Bestellingen(int klantID, int bestellingID, boolean verwerking, int startTijd,int duur, boolean compleet, boolean dadelijk){
        this.klantID = klantID;
        this.bestellingID = bestellingID;
        this.verwerking = verwerking;
        this.startTijd = startTijd;
        this.duur = duur;
        this.compleet = compleet;
        this.dadelijk = dadelijk;

    }

    public static void main(String[] args) {
        Queue<Bestellingen> queue = new Bestellingen<>();

        Bestellingen bestellingen1 = new Bestellingen(1,1,false,1,5,false,true);
        Bestellingen bestellingen2 = new Bestellingen(2,2,false,1,5,false,true);


        queue.enqueue(bestellingen1).enqueue(bestellingen2);

        System.out.println("Elements in queue: " + queue);
       // queue.dequeue();
       // System.out.println("Elements in queue: " + queue);
    }

    private class Node{
        T element;
        Node next;


    }

    @Override
    public Queue<T> enqueue(T ele) {
        Node current = last;
        last = new Node();
        last.element = ele;

        if (total++ == 0) first = last;
        else current.next = last;
        return this;
    }

    @Override
    public T dequeue() {
        if (total == 0) throw new java.util.NoSuchElementException();
        T ele = first.element;

        first = first.next;
        if (--total == 0) last = null;
        return ele;
    }

    @Override
    public T update() {
        Date tijd = new java.sql.Date(new java.util.Date().getTime());

           return null;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;

        while (tmp != null) {
            sb.append(tmp.element).append(", ");
            tmp = tmp.next;

        }
        return sb.toString();
    }

}
