package Practicum;


import java.util.Arrays;

/**
 * Created by Thomas on 28-11-2014.
 */
public class Klanten extends ArrayQueue<Klanten> {

    public static void main(String[] args) {
        int[] notSortedAge = {3, 2, 4, 5, 6, 1, 9, 10};
        sort(notSortedAge);

        String[] notSortedArray = {"maurer", "levens", "maurits","verker"};
        // Search for lastname using linear Search
        System.out.println("Index: " + linearSearch(notSortedArray, "maurits"));

        String sortedArray[] = insertionSort(notSortedArray, notSortedArray.length);
        for (String aSortedArray : sortedArray) {
            System.out.println(aSortedArray);
        }
        // Binary Search
        System.out.println("Index: " + binarySearch(sortedArray,"maurer"));


    }

    /**
    * Insertion Sort
    */

    public static String[] insertionSort(String array[], int arrayLength){
        String tempArray;
        for(int firstIndex = 0 ; firstIndex < arrayLength ; firstIndex++){
            for(int nextIndex = firstIndex + 1 ; nextIndex < arrayLength ; nextIndex++){

                // compareToIgnoreCase returns a negative integer, zero, or a positive integer as the specified String is greater than, equal to, or less than this String.
                if ( array[firstIndex].compareToIgnoreCase( array[nextIndex] ) > 0){
                    tempArray = array[firstIndex];

                    array[firstIndex] = array[nextIndex];

                    array[nextIndex] = tempArray;

                }
            }
        }
        return array;
    }

    /**
    * LinearSearch
    */

    public static int linearSearch(String[] Achternamen, String achternaamInvoer ){

        for (int i = 0; i <Achternamen.length; i++){

            if (Achternamen[i].equals(achternaamInvoer)){
                return i;
            }
        }

        return -1;
    }

    /**
    * Merge Sort
    */
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

        while (tijdelijkLow < middle && tijdelijkMiddel < high){
            tijdelijkeArray[beginPunt++] = (invoerArray[tijdelijkLow] <= invoerArray[tijdelijkMiddel] ? invoerArray[tijdelijkLow++] : invoerArray[tijdelijkMiddel++] );
        }
        System.arraycopy(invoerArray, tijdelijkLow, invoerArray, low+beginPunt, middle-tijdelijkLow);
        System.arraycopy(tijdelijkeArray, 0, invoerArray, low, beginPunt);

    }

    /**
     * Binary Search
     */

    public static int binarySearch(String[] words, String value) {
        return binarySearch(words, value, 0, words.length - 1);
    }

    private static int binarySearch(String[] words, String value, int start, int end) {
        if (start > end) { return -1;  }

        int middle = (end + start) / 2;

        if (words[middle].equals(value)) { return middle;
        } else if(words[middle].compareToIgnoreCase(value) > 0) {
            return binarySearch(words, value, start, middle - 1);
        } else {
            return binarySearch(words, value, middle + 1, end);
        }
    }
}


