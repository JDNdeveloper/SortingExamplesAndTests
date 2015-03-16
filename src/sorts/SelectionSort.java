package sorts;

import java.util.ArrayList;

/**
 * Created by Jayden Navarro on 3/15/2015.
 * Copyright KyJay LLC
 */
public class SelectionSort {

    public static void sort(ArrayList<Integer> theArray) {

        int lowPos = 0;

        for (int i = 0; i < theArray.size(); i++) {

            lowPos = i;

            for (int j = i + 1; j < theArray.size(); j++) {
                if (theArray.get(j) < theArray.get(lowPos))
                    lowPos = j;
            }

            swap(theArray, i, lowPos);
        }
    }

    public static void swap(ArrayList<Integer> theArray, int pos1, int pos2) {
        int num1 = theArray.get(pos1);
        int num2 = theArray.get(pos2);

        theArray.set(pos1, num2);
        theArray.set(pos2, num1);
    }
}
