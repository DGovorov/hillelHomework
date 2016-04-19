package homework8.sorters;

import customCollection.improvedArray.ImprovedArray;

/**
 * Created by Dim on 17.03.2016.
 */
public class CocktailSort extends Sorter {

    @Override
    public void sort(ImprovedArray array) {

        int left = 0;
        int right = array.size() - 1;

        do {
            for (int i = left; i < right; i++) {
                if (compare(array.get(i), array.get(i+1)) > 0) {
                    array.swap(i, i+1);
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (compare(array.get(i), array.get(i-1)) < 0) {
                    array.swap(i, i-1);
                }
            }
            left++;
        } while (left <= right);

    }

    @Override
    public void sort(Object[] unsorted) {
        int left = 0;
        int right = unsorted.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if (compare(unsorted[i], unsorted[i + 1]) > 0) {
                    Object temp = unsorted[i];
                    unsorted[i] = unsorted[i+1];
                    unsorted[i+1] = temp;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (compare(unsorted[i], unsorted[i - 1]) < 0) {
                    Object temp = unsorted[i];
                    unsorted[i] = unsorted[i-1];
                    unsorted[i-1] = temp;
                }
            }
            left++;
        } while (left <= right);
    }
}
