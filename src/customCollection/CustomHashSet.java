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

        addElement(obj, buckets);
    }

    //OPTIMIZE ME
    private void addElement(Object obj, MyList[] elements) {
        int index = calculateIndex(obj, elements.length);

        if (elements[index] != null && !elements[index].contains(obj)) {
            elements[index].add(obj);
            elementCounter++;
        } else {
            MyList toAdd = new CustomLinkedList();
            toAdd.add(obj);
            elements[index] = toAdd;
            elementCounter++;
        }
    }

    //OPTIMIZE ME
    private void resize() {
        elementCounter = 0;
        int oldSize = buckets.length;
        int newSize = oldSize * 2;
        MyList[] newElements = new CustomLinkedList[newSize];

        for (MyList list : buckets) {
            if (list != null) {
                for (Object obj : list) {
                    addElement(obj, newElements);
                }
            }
        }
        buckets = newElements;
    }

    private boolean isOverLoaded() {
        return (elementCounter / buckets.length) > loadFactor;
    }

    private int calculateIndex(Object obj) {
        return obj.hashCode() % buckets.length;
    }

    private int calculateIndex(Object obj, int bucketsLength) {
        return obj.hashCode() % bucketsLength;
    }

    //DELETE ME
    public MyList getList(int index) {
        return buckets[index];
    }

    public int size() {
        return elementCounter;
    }

    public boolean remove(Object obj) {
        int index = calculateIndex(obj);

        return (buckets[index] != null) && buckets[index].remove(obj);
    }

    public boolean removeAll(Object obj) {
        boolean didRemove = false;
        while (contains(obj)) {
            remove(obj);
            didRemove = true;
        }
        return didRemove;
    }

    public boolean contains(Object obj) {
        int index = calculateIndex(obj);

        return (buckets[index] != null) && buckets[index].contains(obj);
    }
}