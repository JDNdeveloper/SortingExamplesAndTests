package sorttests;

import sorts.BubbleSort;
import sorts.MergeSort;
import sorts.QuickSort;
import sorts.SelectionSort;

import java.util.ArrayList;

/**
 * Created by Jayden Navarro on 3/15/2015.
 */
public class SortingTest {

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

    private ArrayList<Integer> generateTestArray() {
        return new ArrayList<Integer>();
    }
}
