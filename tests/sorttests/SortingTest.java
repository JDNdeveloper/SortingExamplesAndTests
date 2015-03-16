package sorttests;

import org.junit.Test;
import sorts.BubbleSort;
import sorts.MergeSort;
import sorts.QuickSort;
import sorts.SelectionSort;

import java.util.ArrayList;

/**
 * Created by Jayden Navarro on 3/15/2015.
 */
public class SortingTest {

    private final int NUMBER_OF_TEST_INPUTS = 1000;
    private final int NUMBER_OF_ARRAY_RANDOMIZES = 50;

    final int SIZE = 10000;
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

    private void randomizeTestArray(ArrayList<Integer> theArray) {

    }

    //specify the size of the input and the range of the input as CONSTANTS
    private void generateTestArray(ArrayList<Integer> theArray) {
        theArray.clear();


    }

    private boolean checkIfSorted(ArrayList<Integer> originalArray, ArrayList<Integer> actual) {


        return true;
    }

    @Test
    public void sortingTests() {

        ArrayList<Integer> originalArray = new ArrayList<Integer>();
        ArrayList<Integer> theArray;

        for (int i = 0; i < NUMBER_OF_TEST_INPUTS; i++) {

            generateTestArray(originalArray);

            theArray = (ArrayList<Integer>) originalArray.clone();

            for (int j = 0; j < NUMBER_OF_ARRAY_RANDOMIZES; j++) {



            }
        }
    }

    //unit tests of test methods (meta)

    @Test
    public void randomizeTestArrayTest() {

    }

    @Test
    public void generateTestArrayTest() {

    }

    @Test
    public void checkIfSortedTest() {

    }
}
