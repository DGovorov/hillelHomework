package homework9;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Dim on 27.03.2016.
 */
public class FloatCollectionSumTest {

    @Test
    public void sumShouldReturnZeroInEmptyCollection() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();
        double expected = 0f;
        double result = example.sum(arrayList);

        Assert.assertEquals(result, expected, 0);
    }

    @Test
    public void sumShouldReturnCorrectResult() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();
        arrayList.add(10f);
        arrayList.add(25f);
        arrayList.add(40f);
        double expected = 75f;
        double result = example.sum(arrayList);
        Assert.assertEquals(result, expected, 0);
    }

    @Test
    public void sumShouldWorkWithMagicNumberWhileIncreasing() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();

        arrayList.add(16_777_216f);
        arrayList.add(1f);
        arrayList.add(1f);
        arrayList.add(1f);
        arrayList.add(1f);
        arrayList.add(1f);

        float result = example.sum(arrayList);
        float expected = 16_777_221f;
        Assert.assertEquals(result, expected, 0);
    }

    @Test
    public void sumShouldWorkWithMagicNumberWhileDecreasing() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();

        arrayList.add(16_777_218f);
        arrayList.add(-1f);
        arrayList.add(-1f);
        arrayList.add(-1f);
        arrayList.add(-1f);
        arrayList.add(-1f);

        float result = example.sum(arrayList);
        float expected = 16_777_213f;
        Assert.assertEquals(result, expected, 0);
    }

    @Test
    public void maxTestShouldWork() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();

        arrayList.add(16_777_216f);
        for (int i = 0; i < 17_000_000; i++) {
            arrayList.add(1f);
        }

        float result = example.sum(arrayList);
        float expected = 16_777_216f + 17_000_000f;
        System.out.println(result);

        Assert.assertEquals(result, expected, 0);
    }

    @Test
    public void customTest() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();

        arrayList.add(16_777_200f);
        arrayList.add(17f);
        arrayList.add(-1f);
        arrayList.add(-15f);
        arrayList.add(16f);
        arrayList.add(2f);
        arrayList.add(-1f);
        arrayList.add(4f);

        float result = example.sum(arrayList);
        float expected = 16_777_222f;
        Assert.assertEquals(result, expected, 0);
    }

    @Test
    public void sumShouldWorkWithNegativeMagicNumber() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();

        arrayList.add(-16_777_216f);
        arrayList.add(-1f);
        arrayList.add(-1f);
        arrayList.add(-1f);
        arrayList.add(-1f);
        arrayList.add(-1f);

        float result = example.sum(arrayList);
        float expected = -16_777_221f;
        Assert.assertEquals(result, expected, 0);
    }

    @Test
    public void sumShouldWorkWithRealNumber() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();

        arrayList.add(1_677_721.6f);
        arrayList.add(0.1f);
        arrayList.add(0.1f);
        arrayList.add(0.1f);
        arrayList.add(0.1f);
        arrayList.add(0.1f);
        arrayList.add(0.1f);

        float result = example.sum(arrayList);
        float expected = 1_677_722.2f;
        Assert.assertEquals(result, expected, 0);
    }

    /*@Test
    public void sumShouldWorkWithRealNumberUltimate() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();

        arrayList.add(1_677_720.0f);
        for (int i = 0; i < 17_000_000; i++) {
            arrayList.add(0.1f);
        }

        float result = example.sum(arrayList);
        float expected = 1_677_720.0f + 1_700_000f;
        Assert.assertEquals(result, expected, 0);
    }*/
}
