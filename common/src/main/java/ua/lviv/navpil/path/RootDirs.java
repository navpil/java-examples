package ua.lviv.navpil.path;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.StreamSupport;

public class RootDirs {

    public static void main(String[] args) throws IOException {
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path rootDirectory : rootDirectories) {
            System.out.printf("Dir is %s%n", rootDirectory);
        }



//        Files.createDirectories(Paths.get("bar").resolve(Paths.get("foo")));

        try(DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("src/main/java/ua/lviv/navpil/streams"), "S*java")) {
            for (Path path : paths) {
                System.out.println(path);
            }
        }

        IsDirectoryFilter isDirectoryFilter = new IsDirectoryFilter();

        try(DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(""), isDirectoryFilter::check)) {
            for (Path path : paths) {
                System.out.println(path);
            }
        }

        Iterable<FileStore> fileStores = FileSystems.getDefault().getFileStores();
        StreamSupport.stream(fileStores.spliterator(), false);


    }

    @FunctionalInterface
    public interface AA {
        String hh();

        default void hello() {
            System.out.println("Hello");
        }
    }

    public static class IsDirectoryFilter {
        public boolean check(Path path) {
            return Files.isDirectory(path);
        }
    }
}
