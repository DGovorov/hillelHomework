package homework7.improvedArray;

import customCollection.MyList;
import customCollection.improvedArray.ImprovedArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Dim on 27.03.2016.
 */
public class ImprovedArrayTest {

    @Test
    public void newInstanceShouldBeCreatedEmpty() {
        MyList list = new ImprovedArray();

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void sizeShouldChangeOnAdd() {
        MyList list = new ImprovedArray();
        list.add(new Object());
        list.add(new Object());

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void getShouldThrowIOOBException(){
        MyList array = new ImprovedArray();
        Object element = new Object();
        array.add(element);
        array.add(element);

        try {
            array.get(2);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    @Test
    public void getShouldThrowIOOBExceptionWithNegativeIndex() {
        MyList array = new ImprovedArray();
        Object element = new Object();
        array.add(element);
        array.add(element);

        try {
            array.get(-1);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    @Test
    public void removeShouldThrowIOOBException(){
        MyList array = new ImprovedArray();
        Object element = new Object();
        array.add(element);
        array.add(element);

        try {
            array.remove(2);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    @Test
    public void removeShouldThrowIOOBExceptionWithNegativeIndex(){
        MyList array = new ImprovedArray();
        Object element = new Object();
        array.add(element);
        array.add(element);

        try {
            array.remove(-1);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    @Test
    public void searchSortedShouldReturnCorrectResults() {
        ImprovedArray array = new ImprovedArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        boolean[] expected = new boolean[8];
        Arrays.fill(expected, true);
        expected[0] = false;
        expected[1] = false;
        expected[7] = false;

        boolean[] results = new boolean[8];
        results[0] = array.containsSorted(-1);
        results[1] = array.containsSorted(0);
        results[2] = array.containsSorted(1);
        results[3] = array.containsSorted(2);
        results[4] = array.containsSorted(3);
        results[5] = array.containsSorted(4);
        results[6] = array.containsSorted(5);
        results[7] = array.containsSorted(6);

        Assert.assertArrayEquals(expected, results);
    }

    @Test
    public void iteratorRemoveShouldRemoveAppropriateElement(){
        MyList array = new ImprovedArray();
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }

        Iterator iterator = array.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(3)){
                iterator.remove();
            }
        }

        ImprovedArray expectedArray = new ImprovedArray();
        expectedArray.add(0);
        expectedArray.add(1);
        expectedArray.add(2);
        expectedArray.add(4);

        boolean[] comparedPairs = new boolean[4];
        for (int i = 0; i < 4; i++) {
            comparedPairs[i] = array.get(i).equals(expectedArray.get(i));
        }

        boolean[] expected = new boolean[4];
        Arrays.fill(expected, true);
        Assert.assertArrayEquals(expected, comparedPairs);
    }

    @Test
    public void iteratorRemoveShouldRemoveAllElementsFromArrayCorrectly(){
        MyList array = new ImprovedArray();
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }

        Iterator iterator = array.iterator();
        while (iterator.hasNext()){
                iterator.remove();
        }

        Assert.assertEquals(array.size(), 0);
    }
}
