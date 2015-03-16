package sorts;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Jayden Navarro on 3/15/2015.
 * Copyright KyJay LLC
 */
public class QuickSort {

    public static void sort(ArrayList<Integer> theArray) {

        quickSort(theArray, 0, theArray.size() - 1);
    }

    public static void quickSort(ArrayList<Integer> theArray, final int LEFT, final int RIGHT) {
        if (RIGHT - LEFT < 1) return;

        //int partitionPosition = partition(theArray, LEFT, RIGHT);
        int partitionPosition = partitionInPlace(theArray, LEFT, RIGHT);

        quickSort(theArray, LEFT, partitionPosition - 1);
        quickSort(theArray, partitionPosition + 1, RIGHT);
    }

    @SuppressWarnings("unchecked")
    public static int partition(ArrayList<Integer> theArray, final int LEFT, final int RIGHT) {

        final int MIDDLE = (LEFT + RIGHT) / 2;
        int pivotValue = medianOfThree(theArray.get(LEFT), theArray.get(MIDDLE), theArray.get(RIGHT));
        int pivot = getPivotPositionFromValue(theArray, LEFT, MIDDLE, RIGHT, pivotValue);

        ArrayList<Integer> leftPartition = new ArrayList<Integer>();
        ArrayList<Integer> rightPartition = new ArrayList<Integer>();

        for (int i = LEFT; i <= RIGHT; i++) {
            if (i == pivot) {
                //do nothing
            } else if (theArray.get(i) < theArray.get(pivot)) {
                leftPartition.add(theArray.get(i));
            } else {
                rightPartition.add(theArray.get(i));
            }
        }

        //does deep copy of new array into the persistent array
        int pos = LEFT;
        for (int leftValue : leftPartition) {
            theArray.set(pos, leftValue);
            pos++;
        }

        pivot = pos;
        theArray.set(pos, pivotValue);
        pos++;

        for (int rightValue : rightPartition) {
            theArray.set(pos, rightValue);
            pos++;
        }

        return pivot;
    }

    public static int partitionInPlace(ArrayList<Integer> theArray, final int LEFT, final int RIGHT) {

        final int MIDDLE = (LEFT + RIGHT) / 2;
        int pivotValue = medianOfThree(theArray.get(LEFT), theArray.get(MIDDLE), theArray.get(RIGHT));
        int pivot = getPivotPositionFromValue(theArray, LEFT, MIDDLE, RIGHT, pivotValue);

        swap(theArray, pivot, RIGHT);

        int storeIndex = LEFT;

        for (int i = LEFT; i <= RIGHT - 1; i++) {
            if (theArray.get(i) < pivotValue) {
                swap(theArray, i, storeIndex);
                storeIndex++;
            }
        }

        swap(theArray, storeIndex, RIGHT);

        return storeIndex;
    }

    public static int getPivotPositionFromValue(ArrayList<Integer> theArray, int pos1, int pos2, int pos3, int pivotValue) {
        if (theArray.get(pos1) == pivotValue) {
            return pos1;
        } else if (theArray.get(pos2) == pivotValue) {
            return pos2;
        } else {
            return pos3;
        }
    }

    public static int medianOfThree(final int num1, final int num2, final int num3) {
        int median = -1;

        if (num1 < num2) {
            if (num1 > num3) {
                median = num1;
            } else {
                if (num2 < num3) {
                    median = num2;
                } else {
                    median = num3;
                }
            }
        } else {
            if (num1 < num3) {
                median = num1;
            } else {
                if (num2 > num3) {
                    median = num2;
                } else {
                    median = num3;
                }
            }
        }

        return median;
    }

    @Test
    public void medianOfThreeTest() {
        assertEquals("Median Test 1.1 failed", 4, medianOfThree(3, 7, 4));
        assertEquals("Median Test 1.2 failed", 4, medianOfThree(7, 3, 4));

        assertEquals("Median Test 2.1 failed", 4, medianOfThree(3, 4, 7));
        assertEquals("Median Test 2.2 failed", 4, medianOfThree(7, 4, 3));

        assertEquals("Median Test 3.1 failed", 4, medianOfThree(4, 7, 3));
        assertEquals("Median Test 3.2 failed", 4, medianOfThree(4, 3, 7));
    }

    public static void swap(ArrayList<Integer> theArray, int pos1, int pos2) {
        int num1 = theArray.get(pos1);
        int num2 = theArray.get(pos2);

        theArray.set(pos1, num2);
        theArray.set(pos2, num1);
    }
}
