package homework10;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by Dim on 24.04.2016.
 */
public class CopyPerformanceStats {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\Dim\\IdeaProjects\\MyFolder\\sourceFile.txt";
        String destinationFilePath = "C:\\Users\\Dim\\IdeaProjects\\MyFolder\\destinationFile.txt";
        File sourceFile = new File(sourceFilePath);
        File destinationFile = new File(destinationFilePath);

        FileCopier copier = new FileCopier();

        Instant begin = Instant.now();
        copier.bufferedFileCopy(sourceFile, destinationFile);
        Instant end = Instant.now();
        long bufferedCopyTime = Duration.between(begin, end).toMillis();
        System.out.println("Buffered copy time: " + bufferedCopyTime + "ms");

        begin = Instant.now();
        copier.streamFileCopy(sourceFile, destinationFile);
        end = Instant.now();
        long streamCopyTime = Duration.between(begin, end).toMillis();
        System.out.println("Stream copy time: " + streamCopyTime + "ms");

        long difference = streamCopyTime / bufferedCopyTime;
        System.out.println("Buffered is " + difference + "times faster!");
    }
}
