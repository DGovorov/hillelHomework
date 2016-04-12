package homework8.comparisonKeys;

import homework7.animals.Animal;

/**
 * Created by Dim on 17.03.2016.
 */
public class CompareAnimals implements ComparisonKeys {

    @Override
    public int compare(Object first, Object second) {
        if(!(first instanceof Animal) || !(second instanceof Animal)){
            return 2/0;
        }

        Animal firstAnimal = (Animal) first;
        Animal secondAnimal = (Animal) second;

        if (firstAnimal.getId() > secondAnimal.getId()) {
            return 1;
        }
        if (firstAnimal.getId() < secondAnimal.getId()) {
            return -1;
        }
        return 0;
    }
}
