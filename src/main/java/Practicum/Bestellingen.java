package Practicum;
/**
 * Created by Thomas on 1-12-2014.
 */
public class Bestellingen extends ArrayQueue<Bestellingen>{

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

    // Getters and setters
    public int getKlantID() {
        return klantID;
    }


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


    public static void main(String[] args) {
        int doorloopTijd = 10;
       //Bestellingen bestellingen = new Bestellingen(1,1,false,5,false,true);

       //bestellingen.add(bestellingen);

        for (int i = 0, klantID = 0, bestellingID = 0; klantID < doorloopTijd; i++, klantID++, bestellingID++) {

            Bestellingen bestellingen = new Bestellingen(klantID,bestellingID,false,5,false,true);

            System.out.println(bestellingen);
        }





    }




}
