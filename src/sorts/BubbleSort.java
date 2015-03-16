package sorts;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jayden Navarro on 3/15/2015.
 * Copyright KyJay LLC
 */
public class BubbleSort {

    public static void sort(ArrayList<Integer> theArray) {
        //Collections.sort(theArray);

        for (int i = 0; i < theArray.size(); i++) {
            for (int j = 1; j < theArray.size() - i; j++) {
                if (theArray.get(j-1) > theArray.get(j))
                    swap(theArray, j-1, j);
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
