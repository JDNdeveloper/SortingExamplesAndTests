package sorttests;

import org.junit.Test;
import sorts.BubbleSort;
import sorts.MergeSort;
import sorts.QuickSort;
import sorts.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Jayden Navarro on 3/15/2015.
 * Copyright KyJay LLC
 */
public class SortingTest {

    private final int NUMBER_OF_TEST_INPUTS = 100;
    private final int NUMBER_OF_ARRAY_RANDOMIZES = 50;

    private Random rand = new Random();

    //generate test arrays constants
    final int SIZE = 1000;
    final int LOWER_BOUND = -100000;
    final int UPPER_BOUND = 100000;

    private enum SortingMethod {
        BUBBLE, MERGE, QUICK, SELECTION
    }

    private boolean runSort(ArrayList<Integer> theArray, SortingMethod sortingMethod) {
        switch (sortingMethod) {
            case BUBBLE:
                BubbleSort.sort(theArray);
                break;
            case MERGE:
                MergeSort.sort(theArray);
                break;
            case QUICK:
                QuickSort.sort(theArray);
                break;
            case SELECTION:
                SelectionSort.sort(theArray);
                break;
            default:
                return false;
        }

        return true;
    }

    private void runAllSorts(ArrayList<Integer> theArray) {
        runFullSortSequence(theArray, SortingMethod.BUBBLE);

        runFullSortSequence(theArray, SortingMethod.MERGE);

        runFullSortSequence(theArray, SortingMethod.QUICK);

        runFullSortSequence(theArray, SortingMethod.SELECTION);
    }

    @SuppressWarnings("unchecked")
    private void runFullSortSequence(ArrayList<Integer> theArray, SortingMethod sortingMethod) {
        ArrayList<Integer> sortingArray = (ArrayList<Integer>) theArray.clone();

        runSort(sortingArray, sortingMethod);

        assertTrue(sortingMethod.name() + ": Arrays are not equal", checkIfSorted(theArray, sortingArray));
    }

    private void randomizeTestArray(ArrayList<Integer> theArray) {
        for (int i = 0; i < theArray.size()-1; i++) {
            int randomLocation = getRandInt(i+1, theArray.size()-1);

            swapArrayPositions(theArray, i, randomLocation);
        }
    }

    private void swapArrayPositions(ArrayList<Integer> theArray, int pos1, int pos2) {
        int num1 = theArray.get(pos1);
        int num2 = theArray.get(pos2);

        theArray.set(pos1, num2);
        theArray.set(pos2, num1);
    }

    //specify the size of the input and the range of the input as Class CONSTANTS
    private void generateTestArray(ArrayList<Integer> theArray) {
        theArray.clear();

        for (int i = 0; i < SIZE; i++) {
            int randomValue = getRandInt(LOWER_BOUND, UPPER_BOUND);

            theArray.add(randomValue);
        }
    }

    //get random integer within given bounds (inclusive)
    private int getRandInt(int min, int max) {

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return rand.nextInt((max - min) + 1) + min;
    }

    @SuppressWarnings("unchecked")
    private boolean checkIfSorted(ArrayList<Integer> theArray, ArrayList<Integer> actual) {
        ArrayList<Integer> originalArray = (ArrayList<Integer>) theArray.clone();

        Collections.sort(originalArray);

        return originalArray.equals(actual);
    }

    @Test
    public void sortingTests() {

        ArrayList<Integer> theArray = new ArrayList<Integer>(SIZE);

        for (int i = 0; i < NUMBER_OF_TEST_INPUTS; i++) {

            generateTestArray(theArray);

            for (int j = 0; j < NUMBER_OF_ARRAY_RANDOMIZES; j++) {

                randomizeTestArray(theArray);

                runAllSorts(theArray);
            }
        }
    }

    //unit tests of test methods (meta)

    @Test
    @SuppressWarnings("unchecked")
    public void randomizeTestArrayTest() {
        for (int i = 0; i < 25000; i++) {
            ArrayList<Integer> testArray = new ArrayList<Integer>(Arrays.asList(5, 3, 2, 7));
            ArrayList<Integer> inputArray = (ArrayList<Integer>) testArray.clone();

            randomizeTestArray(inputArray);

            assertFalse("Arrays match, which they shouldn't", testArray.equals(inputArray));

            Collections.sort(testArray);
            Collections.sort(inputArray);

            assertTrue("Data was lost", testArray.equals(inputArray));
        }
    }

    @Test
    public void generateTestArrayTest() {
        ArrayList<Integer> testArray = new ArrayList<Integer>();

        generateTestArray(testArray);

        assertEquals("Size is incorrect", testArray.size(), SIZE);

        for (int value : testArray) {
            assertTrue("Values are not in proper range", value <= UPPER_BOUND && value >= LOWER_BOUND);
        }
    }

    @Test
    public void checkIfSortedTest() {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(3, 5, 7, 2));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(2, 4, 5, 7));

        assertFalse("Arrays are equal", checkIfSorted(array1, array2));

        array1 = new ArrayList<Integer>(Arrays.asList(3, 5, 7, 2));
        array2 = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7));

        assertTrue("Arrays are not equal", checkIfSorted(array1, array2));
    }
}
