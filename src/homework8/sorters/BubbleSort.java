package homework8.sorters;

import customCollection.improvedArray.ImprovedArray;

/**
 * Created by Dim on 17.03.2016.
 */
public class BubbleSort extends Sorter {

    @Override
    public void sort(ImprovedArray array) {
        boolean swap = false;
        do {
            swap = false;
            for (int i = 0; i < array.size() - 1; i++) {
                if (compare(array.get(i), array.get(i + 1)) > 0) {
                    array.swap(i, i + 1);
                    swap = true;
                }
            }
        } while (swap);
    }

    @Override
    public void sort(Object[] unsorted) {
        boolean swap = false;
        do {
            swap = false;
            for (int i = 0; i < unsorted.length - 1; i++) {
                if (compare(unsorted[i], unsorted[i + 1]) > 0) {
                    Object temp = unsorted[i];
                    unsorted[i] = unsorted[i+1];
                    unsorted[i+1] = temp;
                    swap = true;
                }
            }
        } while (swap);
    }

}
