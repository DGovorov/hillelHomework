package customCollection;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Dim on 15.04.2016.
 */
public class CustomHashSetTest {

    @Test
    public void newInstanceShouldBeCreatedEmpty() {
        CustomHashSet set = new CustomHashSet();

        Assert.assertEquals(0, set.size());
    }

    @Test
    public void sizeShouldChangeOnAdd() {
        CustomHashSet set = new CustomHashSet();
        set.add(new Object());
        set.add(new Object());

        Assert.assertEquals(2, set.size());
    }

    @Test
    public void sizeShouldNotChangeOnAddingDuplicate() {
        CustomHashSet set = new CustomHashSet();

        set.add(21);
        set.add(1);
        set.add(1);

        Assert.assertEquals(2, set.size());
    }

    @Test
    public void containsShouldReturnTrueWhenElementIsInHashSet() {
        CustomHashSet set = new CustomHashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        boolean result = set.contains(2);

        Assert.assertEquals(true, result);
    }

    @Test
    public void containsShouldReturnFalseWhenElementIsNotInHashSet() {
        CustomHashSet set = new CustomHashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        boolean result = set.contains(4);

        Assert.assertEquals(false, result);
    }

    @Test
    public void removeShouldRemoveElementAndReturnTrueOnRemoval() {
        CustomHashSet set = new CustomHashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        boolean result = set.remove(2) && !set.contains(2);

        Assert.assertEquals(true, result);
    }

    @Test
    public void removeShouldReturnFalseWhenDidNotRemoveAnything() {
        CustomHashSet set = new CustomHashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        boolean result = set.remove(4);

        Assert.assertEquals(false, result);
    }

    @Test
    public void sizeShouldChangeOnRemove() {
        CustomHashSet set = new CustomHashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(2);

        Assert.assertEquals(2, set.size());
    }

}
