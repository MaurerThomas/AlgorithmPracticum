package Practicum;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Thomas on 28-11-2014.
 */
public class Klanten extends Bestellingen {

    public static void main(String[] args) {


        String[] Achternamen = new String[3] ;
        int[] leeftijd = {12,54,23,65,32,76,78,4};
        Scanner scn = new Scanner(System.in);

        System.out.println("Nieuwe klanten toevoegen? y/n");
        String nieuweKlanten = scn.nextLine();
        if (nieuweKlanten.equals("y")) {

            for (int i = 0; i < Achternamen.length; i++){
                System.out.println("Voer achternaam in");
                Achternamen[i] = scn.nextLine();

        }

        }

        System.out.println("Wilt u zoeken via de linear search methode? y/n");
        String linearZoeker = scn.nextLine();

        if (linearZoeker.equals("y")) {

            System.out.println("Zoek op achternaam");
            String zoekTerm;
            zoekTerm = scn.next();
            System.out.println("search(achternamen): " + linearSearch(Achternamen, zoekTerm));
        } else {
            sort(leeftijd);
            //System.out.println("Dan niet...");
        }

        System.out.println("Wilt u leeftijden sorteren via merge sort? y/n");



    }

    public static int linearSearch(String[] Achternamen, String achternaamInvoer ){

        for (int i = 0; i <Achternamen.length; i++){

            if (Achternamen[i].equals(achternaamInvoer)){
                return i;
            }
        }

        return -1;
    }

    public static void sort(int[] a){
        sort(a, 0 ,a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int [] a, int p, int q){
        if (q - p < 2){
            return;
        }
        int m = (p + q)/2;
        sort(a, p, m);
        sort(a ,m ,q);
        merge(a, p, m, q);


    }

    private static void merge(int [] a,int p, int m, int q){
        if (a[m-1] <= a[m]){
            return;
        }
        int i = p, j = m , k = 0;
        int [] tmp = new int [q-p];
        while (i < m && j < q){
            tmp[k++] = (a[i] <= a[j] ? a[i++] : a[j++] );
        }
        System.arraycopy(a, i, a, p+k, m-i);
        System.arraycopy(tmp, 0, a, p, k);

    }

}
