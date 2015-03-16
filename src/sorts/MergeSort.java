package sorts;

import java.util.ArrayList;

/**
 * Created by Jayden Navarro on 3/15/2015.
 * Copyright KyJay LLC
 */
public class MergeSort {

    public static void sort(ArrayList<Integer> theArray) {

        mergeSort(theArray, 0, theArray.size()-1);
    }

    public static void mergeSort(ArrayList<Integer> theArray, final int LEFT, final int RIGHT) {
        if (RIGHT - LEFT < 1) return;

        final int MIDDLE = (LEFT + RIGHT) / 2;

        mergeSort(theArray, LEFT, MIDDLE);
        mergeSort(theArray, MIDDLE + 1, RIGHT);

        merge(theArray, LEFT, RIGHT);
    }

    @SuppressWarnings("unchecked")
    public static void merge(ArrayList<Integer> theArray, final int LEFT, final int RIGHT) {
        final int MIDDLE = (LEFT + RIGHT) / 2;

        ArrayList<Integer> mergedArray = (ArrayList<Integer>) theArray.clone();

        int leftPos = LEFT;
        int rightPos = MIDDLE + 1;

        int globalLocation = LEFT;

        while (leftPos <= MIDDLE && rightPos <= RIGHT) {
            if (theArray.get(leftPos) < theArray.get(rightPos)) {
                mergedArray.set(globalLocation, theArray.get(leftPos));
                leftPos++;
            } else {
                mergedArray.set(globalLocation, theArray.get(rightPos));
                rightPos++;
            }

            globalLocation++;
        }

        for (; leftPos <= MIDDLE; leftPos++) {
            mergedArray.set(globalLocation, theArray.get(leftPos));

            globalLocation++;
        }

        for (; rightPos <= RIGHT; rightPos++) {
            mergedArray.set(globalLocation, theArray.get(rightPos));

            globalLocation++;
        }

        //does deep copy of new array into the persistent array
        for (int i = LEFT; i <= RIGHT; i++) {
            theArray.set(i, mergedArray.get(i));
        }
    }
}
