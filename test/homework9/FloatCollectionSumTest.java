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

        Float tempSum;

        arrayList.add(16_777_216f);
        arrayList.add(1f);
        tempSum = example.sum(arrayList);
        System.out.println(tempSum);
        arrayList.add(1f);
        tempSum = example.sum(arrayList);
        System.out.println(tempSum);
        arrayList.add(1f);
        tempSum = example.sum(arrayList);
        System.out.println(tempSum);


        float result = example.sum(arrayList);
        float expected = 16_777_219f;
        System.out.println();
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
        Assert.assertEquals(result, expected, 0);
        System.out.println(expected);
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

        System.out.println(example.sum(arrayList));

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

/*    @Test
    public void sumShouldWorkWithRealNumber() {
        FloatCollectionSum example = new FloatCollectionSum();
        ArrayList<Float> arrayList = new ArrayList<>();

        arrayList.add(16_777_2.16f);
        arrayList.add(0.01f);
        System.out.println(example.sum(arrayList));
        arrayList.add(0.01f);
        System.out.println(example.sum(arrayList));
        arrayList.add(0.01f);
        System.out.println(example.sum(arrayList));

        float result = example.sum(arrayList);
        float expected = 16_777_2.19f;
        Assert.assertEquals(result, expected, 0);
    }*/
}
