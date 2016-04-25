package homework10;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Dim on 21.04.2016.
 */
public class FileGenerator {

    public void generateFile(String fileName, int kilobytes) {
        File file = new File(fileName);
        if (!file.exists()){
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName, true))) {
            int iterations = kilobytes*256;
            for (int i = 0; i < iterations; i++) {
                output.writeInt(Integer.MAX_VALUE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateFileFaster(String fileName, int kilobytes){
        File file = new File(fileName);
        if (!file.exists()){
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            int iterations = kilobytes*1024/3; //awful workaround
            for (int i = 0; i < iterations; i++) {
                writer.write(Integer.MAX_VALUE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FileGenerator generator = new FileGenerator();
        generator.generateFile("firstFile.dat", 5000);
        generator.generateFileFaster("secondFile.dat", 5000);
    }
}
