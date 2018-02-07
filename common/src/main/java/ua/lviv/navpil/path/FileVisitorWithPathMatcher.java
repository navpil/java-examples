package ua.lviv.navpil.path;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class FileVisitorWithPathMatcher {

    public static void main(String[] args) throws IOException {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.class");

        SimpleFileVisitor<Path> stringSimpleFileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                FileVisitResult fileVisitResult = super.visitFile(file, attrs);

                if (pathMatcher.matches(file.getFileName())) {
                    System.out.printf("File is of type %s%n", Files.probeContentType(file.getFileName()));
                    System.out.printf("Visited file %s with filename %s%n", file, file.getFileName());
                }
                return fileVisitResult;
            }
        };

        EnumSet<FileVisitOption> followLinks = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

//        Files.walk(Paths.get("")).forEach(System.out::println);
        Files.walkFileTree(Paths.get(""), followLinks, Integer.MAX_VALUE, stringSimpleFileVisitor);

    }


}
