package ua.lviv.navpil.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFilesAreNotRemovedAutomatically {
    public static void main(String[] args) throws IOException {
        Path tempFile = Files.createTempFile(null, ".polo");
        System.out.printf("File %s was created%n", tempFile);

        Files.delete(tempFile);
    }
}
