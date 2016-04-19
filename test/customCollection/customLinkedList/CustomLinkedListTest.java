package customCollection.customLinkedList;

import customCollection.customLinkedList.CustomLinkedList;
import customCollection.MyList;
import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by User on 22.03.2016.
 */
public class CustomLinkedListTest {

    @Test
    public void newInstanceShouldBeCreatedEmpty() {
        MyList list = new CustomLinkedList();

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void sizeShouldChangeOnAdd() {
        MyList list = new CustomLinkedList();

        list.add(new Object());
        list.add(new Object());

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void getShouldReturnAppropriateElement() {
        MyList list = new CustomLinkedList();

        Object element = new Object();

        list.add(element);
        list.add(element);

        Assert.assertEquals(element, list.get(0));
        Assert.assertEquals(element, list.get(1));
    }

    @Test
    public void getShouldThrowIOOBException() {
        MyList list = new CustomLinkedList();

        Object element = new Object();

        list.add(element);
        list.add(element);

        try {
            list.get(2);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    @Test
    public void containsShouldReturnCorrectResult() {
        MyList list = new CustomLinkedList();

        list.add(25);
        list.add(50);

        Assert.assertEquals(true, list.contains(50));
    }

    @Test
    public void equalsTest() {
        MyList list = new CustomLinkedList();
        MyList list2 = new CustomLinkedList();

        list.add(25);
        list.add(50);
        list.add(60);
        list2.add(25);
        list2.add(50);
        list2.add(60);

        Assert.assertEquals(true, list.equals(list2));
    }

    @Test
    public void removeByValueTest() {
        MyList list = new CustomLinkedList();
        MyList list2 = new CustomLinkedList();

        list.add(25);
        list.add(50);
        list.add(60);
        list2.add(25);
        list2.add(60);

        System.out.println("list before remove: " + list);
        list.remove((Integer) 50);
        System.out.println("list after remove: " + list);

        Assert.assertEquals(true, list.equals(list2));
    }

    @Test
    public void removeByIndexTest() {
        MyList list = new CustomLinkedList();
        MyList list2 = new CustomLinkedList();

        list.add(25);
        list.add(50);
        list.add(60);
        list2.add(25);
        list2.add(60);

        System.out.println("list before remove: " + list);
        list.remove(1);
        System.out.println("list after remove: " + list);

        Assert.assertEquals(true, list.equals(list2));
    }

    @Test
    public void removeShouldThrowIOOBException() {
        MyList list = new CustomLinkedList();

        list.add(25);
        list.add(50);

        try {
            list.remove(2);
            System.out.println(list);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    @Test
    public void iteratorRemoveShouldRemoveAppropriateElement(){
        MyList list = new CustomLinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(3)){
                iterator.remove();
            }
        }

        CustomLinkedList expectedList = new CustomLinkedList();
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(4);

        boolean[] comparedPairs = new boolean[4];
        for (int i = 0; i < 4; i++) {
            comparedPairs[i] = list.get(i).equals(expectedList.get(i));
        }

        boolean[] expected = new boolean[4];
        Arrays.fill(expected, true);
        Assert.assertArrayEquals(expected, comparedPairs);
    }

    @Test
    public void iteratorRemoveShouldRemoveAllElementsFromArrayCorrectly(){
        MyList list = new CustomLinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.remove();
        }

        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void toStringTest() {
        MyList list = new CustomLinkedList();
        MyList list2 = new CustomLinkedList();

        list.add(25);
        list.add(50);

        System.out.println(list.toString());
        System.out.println(list2.toString());
    }
}