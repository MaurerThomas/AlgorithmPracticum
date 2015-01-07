package Practicum;
/**
 * Created by Thomas on 1-12-2014.
 */
public class Bestellingen extends ArrayQueue<Bestellingen>{
    private static ArrayQueue<Bestellingen> queue = new ArrayQueue<Bestellingen>(10);

    protected int klantID;
    protected int bestellingID;
    protected boolean verwerking;
    protected int startTijd;
    protected int duur;
    protected boolean compleet;
    protected boolean dadelijk;


    public Bestellingen(int klantID, int bestellingID, boolean verwerking, int duur, boolean compleet, boolean dadelijk){
        this.klantID = klantID;
        this.bestellingID = bestellingID;
        this.verwerking = verwerking;
        this.duur = duur;
        this.compleet = compleet;
        this.dadelijk = dadelijk;

    }

    public String toString() {
        return "KlantID:" + this.klantID + ","
                + "BestellingID:" + this.bestellingID + "," + "Verwerking:"
                + this.verwerking + "," + "Tijd:" + this.duur + "," + "Compleet:" + this.compleet + "," + "Wacht op bestelling:" + this.dadelijk;
    }

    // Getters and setters
    public int getKlantID() {return klantID;}

    public int getBestellingID() {
        return bestellingID;
    }

    public boolean isVerwerking() {
        return verwerking;
    }

    public int getStartTijd() {
        return startTijd;
    }

    public int getDuur() {
        return duur;
    }

    public boolean isCompleet() {
        return compleet;
    }

    public boolean isDadelijk() {
        return dadelijk;
    }

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

    public static void main(String[] args) {


       Bestellingen bestellingen = new Bestellingen(1,1,false,5,false,true);
       Bestellingen bestellingen2 = new Bestellingen(2,2,true,7,true,false);

        queue.add(bestellingen);
        queue.add(bestellingen2);
        System.out.println(queue);
        System.out.println("Element to remove: " + queue.element());
        System.out.println("remove: " + queue.remove());
        System.out.println(queue);

    }
}
