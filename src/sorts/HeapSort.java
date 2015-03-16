package sorts;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Jayden Navarro on 3/16/2015.
 */
public class HeapSort {

    public static void sort(ArrayList<Integer> theArray) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(theArray);

        for (int i = 0; i < theArray.size(); i++) {
            int min = heap.poll();

            theArray.set(i, min);
        }
    }
}
