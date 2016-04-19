package customCollection;

import homework7.animals.Cat;

import java.io.*;
import java.util.Random;

/**
 * Created by Dim on 14.04.2016.
 */
public class CustomHashSetMain {
    public static void main(String[] args) {
        CustomHashSet set = new CustomHashSet();


        Random r = new Random();
        for (int i = 0; i < 60; i++) {
            set.add(r.nextInt(100));
        }

        set.add(new Cat(7602, "Barsik", 12, 3, "blue", true));
        set.add(new Cat(5042, "Murzik", 12, 3, "blue", true));
        set.add(new Cat(2152, "Vas'ka", 12, 3, "blue", true));
        set.add(new Cat(1512, "Crawford", 12, 3, "blue", true));
        set.add(new Cat(6123, "Sherlock", 12, 3, "blue", true));


        System.out.println();
        System.out.println("number of filled cells: " + set.getLoadFactor());

        System.out.println(set.removeAll(0));
        bufferedWrite(set);
    }

    private static void bufferedWrite(CustomHashSet set) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CustomHashSet.txt", true))) {
            //Files.createFile(Paths.get("CustomHashSet.txt"));
            String value;
            for (int i = 0; i < set.size(); i++) {
                if (set.getList(i) != null) {
                    value = set.getList(i).toString() + "\t";
                    writer.write(value);
                } else {
                    writer.write("null\t");
                }
                if (i % 10 == 9){
                    writer.newLine();
                }
            }
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}