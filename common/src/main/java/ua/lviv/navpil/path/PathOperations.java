package ua.lviv.navpil.path;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperations {

    public static void main(String[] args) throws IOException {
//        Path p1 = Paths.get("/tmp/foo");
//        Path p3 = Paths.get(URI.create("file:///Users/joe/testfile.txt"));

        System.out.println(FileSystems.getDefault().getPath("/"));

        Path path = Paths.get("home\\dmp\\foo.txt");
        System.out.println(path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByGroupName("csia"));

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        System.out.println(path.toAbsolutePath().toUri());
//        path.toRealPath(LinkOption.NOFOLLOW_LINKS);


        System.out.println(Paths.get("foo").resolve("/home/joe").toString());
    }
}
