package customCollection;

import customCollection.customLinkedList.CustomLinkedList;

/**
 * Created by Dim on 14.04.2016.
 */
public class CustomHashSet {

    private MyList[] elements = new CustomLinkedList[10];
    private int loadFactor;

    public void add(Object obj) {
        if (isOverLoaded()){
            resize();
        }

        addElement(obj, elements);
    }

    private void addElement(Object obj, MyList[] elements) {
        int index = calculateIndex(obj);

        if (elements[index] != null && !contains(obj)) {
            elements[index].add(obj);
        } else {

            MyList toAdd = new CustomLinkedList();
            toAdd.add(obj);
            elements[index] = toAdd;
            loadFactor++;
        }
    }

    //OPTIMIZE ME
    private void resize() {
        loadFactor = 0;
        int oldSize = elements.length;
        int newSize = oldSize * 2;
        MyList[] newElements = new CustomLinkedList[newSize];

        for (MyList list : elements) {
            if (list != null) {
                for (Object obj : list) {
                    addElement(obj, newElements);
                }
            }
        }
        elements = newElements;
    }



    //Unnecessary double variables
    private boolean isOverLoaded() {
        double filledCells = loadFactor;
        double totalCells = elements.length;

        return (filledCells / totalCells) > 0.7;
    }

    private int calculateIndex(Object obj) {
        return obj.hashCode() % elements.length;
    }

    //DELETE ME
    public int getLoadFactor() {
        return loadFactor;
    }

    //DELETE ME
    public MyList getList(int index) {
        return elements[index];
    }

    //DELETE ME
    public int size() {
        return elements.length;
    }

    public boolean remove(Object obj) {
        int index = calculateIndex(obj);

        return (elements[index] != null) && elements[index].remove(obj);
    }

    public boolean removeAll(Object obj){
        boolean didRemove = false;
        while (contains(obj)){
            remove(obj);
            didRemove = true;
        }
        return didRemove;
    }

    public boolean contains(Object obj) {
        int index = calculateIndex(obj);

        return (elements[index] != null) && elements[index].contains(obj);
    }
}