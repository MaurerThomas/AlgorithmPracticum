package Practicum;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Thomas on 1-12-2014.
 */
public class Bestellingen{

    protected int klantID;
    protected int bestellingID;
    protected boolean verwerking;
    protected int startTijd;
    protected int duur;
    protected boolean compleet;
    protected boolean dadelijk;

    public int getKlantID() {
        return klantID;
    }

    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }

    public int getBestellingID() {
        return bestellingID;
    }

    public void setBestellingID(int bestellingID) {
        this.bestellingID = bestellingID;
    }

    public boolean isVerwerking() {
        return verwerking;
    }

    public void setVerwerking(boolean verwerking) {
        this.verwerking = verwerking;
    }

    public int getStartTijd() {
        return startTijd;
    }

    public void setStartTijd(int startTijd) {
        this.startTijd = startTijd;
    }

    public int getDuur() {
        return duur;
    }

    public void setDuur(int duur) {
        this.duur = duur;
    }

    public boolean isCompleet() {
        return compleet;
    }

    public void setCompleet(boolean compleet) {
        this.compleet = compleet;
    }

    public boolean isDadelijk() {
        return dadelijk;
    }

    public void setDadelijk(boolean dadelijk) {
        this.dadelijk = dadelijk;
    }

    public static void main(String[] args) {

        Queue<String> queue = new ArrayDeque<String>();

    }

    public Bestellingen(){

        Bestellingen bestellingen = new Bestellingen();



    }



}
