package homework9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dim on 26.03.2016.
 */
public class FloatCollectionSum {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.print(16_777_221f + i + "\t");

            System.out.println(16_777_221f + i + 1);
        }
    }

    /**
     * sum1
     * Working just fine with natural_numbers in all cases,
     * Can't calculate around real_numbers like:
     * 1_677_721.6 + 0.1 + 0.1;
     * @param collection of Float
     * @return Sum of all elements in collection
     */
    public float sum1(Collection<Float> collection) {
        float sum = 0;
        int deviation = 0;
        for (Float o : collection) {
            if (sum + o == sum + o + 1) {
                if (sum + (o + 2) == sum + o + 3) {
                    deviation += 1;
                }
            }
            if (sum + o == sum + o - 1) {
                if (sum + (o - 2) == sum + o - 3) {
                    deviation -= 1;
                }
            }
            sum += o;
        }
        return sum + deviation;
    }

    /**
     * sum2
     * More appropriate logic, requires tuning to be usable
     * @param collection of Float
     * @return Sum of all elements in collection
     */
    public float sum2(Collection<Float> collection) {
        float sum1 = 0;
        float sum2 = 0;
        for (Float element : collection) {
            if (sum1 + element == sum1 && element != 0) {
                if (sum2 != 0) {
                    sum2 += element;
                    sum1 += sum2;
                    sum2 = 0;
                } else {
                    sum2 += element;
                }
            } else {
                sum1 += element;
            }
        }
        return sum1 + sum2;
    }

    /**
     * sum3
     * Much slower logic with recursive approach.
     * Can't guarantee very accurate results.
     * @param collection of Float
     * @return Sum of all elements in collection
     */
    public float sum3(Collection<Float> collection) {
        float sum = 0;
        List<Float> temp = new ArrayList<>();
        for (Float element : collection) {
            if (sum + element == sum && element != 0) {
                temp.add(element);
            } else {
                sum += element;
            }
        }
        if (temp.size() != 0) {
            FloatCollectionSum floatCollectionSum = new FloatCollectionSum();
            return sum + floatCollectionSum.sum(temp);
        }
        return sum;
    }

    /**
     * sum4
     *Variation of sum3, with different condition,
     *Still doesnt work with real numbers:
     * 1_677_721.6 + 0.1 + 0.1 = 1_677_721.9;
     * @param collection of Float
     * @return Sum of all elements in collection
     */
    public float sum4(Collection<Float> collection) {
        float sum = 0;
        List<Float> temp = new ArrayList<>();
        for (Float element : collection) {
            if(sum + element - element != sum) {
                temp.add(element);
            } else {
                sum += element;
            }
        }
        if (temp.size() != 0) {
            FloatCollectionSum floatCollectionSum = new FloatCollectionSum();
            return sum + floatCollectionSum.sum(temp);
        }
        return sum;
    }

    /**
     * sum5
     * Variation of sum2
     * More appropriate logic, requires tuning to be usable
     * @param collection of Float
     * @return Sum of all elements in collection
     */
    public float sum(Collection<Float> collection) {
        float sum1 = 0;
        float sum2 = 0;
        for (Float element : collection) {
            if (sum1 + element - element != sum1) {
                if (sum2 != 0) {
                    sum2 += element;
                    sum1 += sum2;
                    sum2 = 0;
                } else {
                    sum2 += element;
                }
            } else {
                sum1 += element;
            }
        }
        return sum1 + sum2;
    }
}
