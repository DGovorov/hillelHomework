package customCollection;

import customCollection.customLinkedList.CustomLinkedList;

/**
 * Created by Dim on 14.04.2016.
 */
public class CustomHashSet {

    private MyList[] buckets = new CustomLinkedList[10];
    private int elementCounter;
    private double loadFactor = 0.75;

    public CustomHashSet() {

    }

    public CustomHashSet(double loadFactor) {
        if (loadFactor > 0) {
            this.loadFactor = loadFactor;
        } else {
            throw new NegativeLoadFactorException();
        }
    }

    public void add(Object obj) {
        if (isOverLoaded()) {
            resize();
        }

        addElement(obj);
    }

    private void addElement(Object obj) {
        int index = calculateIndex(obj);

        if (buckets[index] == null){
            MyList toAdd = new CustomLinkedList();
            toAdd.add(obj);
            buckets[index] = toAdd;
            elementCounter++;
        } else if (!buckets[index].contains(obj)){
            buckets[index].add(obj);
            elementCounter++;
        }
    }

    private void resize() {
        elementCounter = 0;
        int oldSize = buckets.length;
        int newSize = oldSize * 2;
        MyList[] oldBuckets = buckets;
        this.buckets = new CustomLinkedList[newSize];

        for (MyList bucket : oldBuckets) {
            if (bucket != null) {
                for (Object obj : bucket) {
                    addElement(obj);
                }
            }
        }
    }

    private boolean isOverLoaded() {
        return (elementCounter / buckets.length) > loadFactor;
    }

    private int calculateIndex(Object obj) {
        return Math.abs(obj.hashCode() % buckets.length);
    }

    public int size() {
        return elementCounter;
    }

    public boolean remove(Object obj) {
        int index = calculateIndex(obj);

        if ((buckets[index] != null) && buckets[index].remove(obj)){
            elementCounter--;
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(Object obj) {
        int index = calculateIndex(obj);

        return (buckets[index] != null) && buckets[index].contains(obj);
    }

}