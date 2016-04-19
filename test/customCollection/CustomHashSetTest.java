package customCollection;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Dim on 15.04.2016.
 */
public class CustomHashSetTest {

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

}
