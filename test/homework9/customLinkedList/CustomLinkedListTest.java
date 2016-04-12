package homework9.customLinkedList;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by User on 22.03.2016.
 */
public class CustomLinkedListTest {

    @Test
    public void newInstanceShouldBeCreatedEmpty() {
        CustomLinkedList list = new CustomLinkedList();

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void sizeShouldChangeOnAdd() {
        CustomLinkedList list = new CustomLinkedList();

        list.add(new Object());
        list.add(new Object());

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void getShouldReturnAppropriateElement() {
        CustomLinkedList list = new CustomLinkedList();

        Object element = new Object();

        list.add(element);
        list.add(element);

        Assert.assertEquals(element, list.get(0));
        Assert.assertEquals(element, list.get(1));
    }

    @Test
    public void containsShouldReturnCorrectResult() {
        CustomLinkedList list = new CustomLinkedList();

        list.add(25);
        list.add(50);

        Assert.assertEquals(true, list.contains(50));
    }

    @Test
    public void toStringTest() {
        CustomLinkedList list = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();

        list.add(25);
        list.add(50);

        System.out.println(list.toString());
        System.out.println(list2.toString());
    }

    @Test
    public void equalsTest() {
        CustomLinkedList list = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();

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
        CustomLinkedList list = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();

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
        CustomLinkedList list = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();

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
}