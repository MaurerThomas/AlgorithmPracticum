package Practicum;


import java.util.Arrays;

/**
 * Created by Thomas on 28-11-2014.
 */
public class Klanten extends ArrayQueue<Klanten> {

    public static void main(String[] args) {


    }

    public static int linearSearch(String[] Achternamen, String achternaamInvoer ){

        for (int i = 0; i <Achternamen.length; i++){

            if (Achternamen[i].equals(achternaamInvoer)){
                return i;
            }
        }

        return -1;
    }


    public static void sort(int[] invoerArray){
        sort(invoerArray, 0 ,invoerArray.length);
        System.out.println(Arrays.toString(invoerArray));
    }

    private static void sort(int [] invoerArray, int low, int high){
        if (high - low < 2){
            return;
        }
        int middle = (low + high)/2;
        sort(invoerArray, low, middle);
        sort(invoerArray ,middle ,high);
        merge(invoerArray, low, middle, high);


    }

    private static void merge(int [] invoerArray,int low, int middle, int high){
        if (invoerArray[middle-1] <= invoerArray[middle]){
            return;
        }
        int tijdelijkLow = low, tijdelijkMiddel = middle , beginPunt = 0;
        int [] tijdelijkeArray = new int [high-low];
        System.out.println(Arrays.toString(tijdelijkeArray));
        while (tijdelijkLow < middle && tijdelijkMiddel < high){
            tijdelijkeArray[beginPunt++] = (invoerArray[tijdelijkLow] <= invoerArray[tijdelijkMiddel] ? invoerArray[tijdelijkLow++] : invoerArray[tijdelijkMiddel++] );
        }
        System.arraycopy(invoerArray, tijdelijkLow, invoerArray, low+beginPunt, middle-tijdelijkLow);
        System.arraycopy(tijdelijkeArray, 0, invoerArray, low, beginPunt);

    }

}
