package homework8.sorters;

import customCollection.improvedArray.ImprovedArray;
import homework7.animals.*;
import homework8.comparisonKeys.CompareAnimals;

/**
 * Created by Dim on 17.03.2016.
 */
public class SortersMain {

    public static void main(String[] args) {

        sortingIntegers();

        sortingAbsoluteArrayOfAnimals();

        sortingObjectsArrayOfAnimals();

    }

    private static void sortingObjectsArrayOfAnimals() {
        System.out.println("===Sorting Object[] of Animals===");
        Sorter animalSorter = new CocktailSort();
        animalSorter.setKey(new CompareAnimals());
        Animal[] animalArray = new Animal[4];
        animalArray[0] = new Cat(4);
        animalArray[1] = new Dog(8);
        animalArray[2] = new Crocodile(1);
        animalArray[3] = new Lion(2);

        animalSorter.sort(animalArray);
        for (Object element: animalArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void sortingAbsoluteArrayOfAnimals() {
        System.out.println("===Sorting ImprovedArray of Animals===");
        Sorter animalSorter = new CocktailSort();
        animalSorter.setKey(new CompareAnimals());
        ImprovedArray animals = new ImprovedArray();
        animals.add(new Cat(4));
        animals.add(new Dog(8));
        animals.add(new Crocodile(1));
        animals.add(new Lion(2));

        animalSorter.sort(animals);
        System.out.println(animals);
    }

    private static void sortingIntegers() {
        System.out.println("===Sorting Integers===");
        Integer[] intArray = {4, 3, 2, 1, 5, 7};
        Sorter sorter = new CocktailSort();
        sorter.sort(intArray);
        for (Integer element:intArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
