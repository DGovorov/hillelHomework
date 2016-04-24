package homework10;

import java.io.*;

/**
 * Created by Dim on 24.04.2016.
 */
public class FileCopier {

    public void streamFileCopy(File source, File destination) {
        try (
                InputStream inputStream = new FileInputStream(source);
                OutputStream outputStream = new FileOutputStream(destination);
        ) {
            int value;
            while ((value = inputStream.read()) != -1) {
                outputStream.write(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bufferedFileCopy(File source, File destination) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
        ) {
            String value;
            while ((value = reader.readLine()) != null) {
                writer.write(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
