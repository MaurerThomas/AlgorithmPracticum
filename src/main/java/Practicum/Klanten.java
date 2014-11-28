package Practicum;


import java.util.Scanner;

/**
 * Created by Thomas on 28-11-2014.
 */
public class Klanten {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String[] Achternamen = new String[3] ;
        for (int i = 0; i < Achternamen.length; i++){
            System.out.println("Voer achternaam in");
            Achternamen[i] = scn.nextLine();
        }

        System.out.println("Wilt u zoeken via de linear search methode? y/n");
        String linearZoeker = scn.nextLine();

        if (linearZoeker.equals("y")) {

            System.out.println("Zoek op achternaam");
            String zoekTerm;
            zoekTerm = scn.next();
            System.out.println("search(achternamen): " + linearSearch(Achternamen, zoekTerm));
        } else {
            System.out.println("Dan niet...");
        }
    }

    public static int linearSearch(String[] Achternamen, String achternaamInvoer ){

        for (int i = 0; i <Achternamen.length; i++){

            if (Achternamen[i].equals(achternaamInvoer)){
                return i;
            }
        }

        return -1;
    }

}
