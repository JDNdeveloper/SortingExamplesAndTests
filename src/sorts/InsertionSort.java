package sorts;

import java.util.ArrayList;

/**
 * Created by Jayden Navarro on 3/16/2015.
 */
public class InsertionSort {

    public static void sort(ArrayList<Integer> theArray) {

        for (int i = 1; i < theArray.size(); i++) {
            int current = i;
            int previous = i - 1;

            //order of the terms in this statement matter! otherwise array out of bounds error
            while (previous >= 0 && theArray.get(previous) > theArray.get(current)) {
                swap(theArray, current, previous);
                previous--;
                current--;
            }

        }
    }

    public static void swap(ArrayList<Integer> theArray, int pos1, int pos2) {
        int num1 = theArray.get(pos1);
        int num2 = theArray.get(pos2);

        theArray.set(pos1, num2);
        theArray.set(pos2, num1);
    }
}
