package homework8.comparisonKeys;

/**
 * Created by Dim on 17.03.2016.
 */
public class ComparableObjects implements ComparisonKeys {

    @Override
    public int compare(Object firstObj, Object secondObj) {
/*        if(!(firstObj instanceof Comparable) || !(secondObj instanceof Comparable)){
            return 0;
        }*/
        Comparable firstObject = (Comparable) firstObj;
        Comparable secondObject = (Comparable) secondObj;

        return firstObject.compareTo(secondObject);
    }
}
