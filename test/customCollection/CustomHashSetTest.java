package customCollection;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Dim on 15.04.2016.
 */
public class CustomHashSetTest {

    @Test
    public void newInstanceShouldBeCreatedEmpty(){
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
    public void sizeShouldChangeOnRemove() {
        CustomHashSet set = new CustomHashSet();
        set.add(new Object());
        set.add(new Object());

        set.remove(1);

        Assert.assertEquals(1, set.size());
    }

    @Test
    public void containsShouldReturnAppropriateResult() {
        CustomHashSet set = new CustomHashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        boolean result = set.contains(2);

        Assert.assertEquals(true, result);

    }

}
