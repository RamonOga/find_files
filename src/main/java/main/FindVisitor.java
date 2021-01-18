package main;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FindVisitor implements FileVisitor<Path> {
    private List<Path> findList = new ArrayList<>();
    private Predicate<String> predicate;

    public FindVisitor(final String findType,final String fileName) {
        if (findType.equals("f ")) {
            predicate = new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return s.equals(fileName);
                }
            };
        }
        if (findType.equals("m ")) {
            predicate = new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return s.endsWith(fileName.split(".")[1]);
                }
            };
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file.getFileName().toString())) {
            findList.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getFindList() {
        return findList;
    }
}
