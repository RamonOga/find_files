package main;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FindVisitor extends SimpleFileVisitor<Path> {
    private List<Path> findList = new ArrayList<>();
    Predicate<Path> predicate;

    public FindVisitor(Predicate<Path> pred) {
        this.predicate = pred;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (predicate.test(file)) {
            findList.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getFindList() {
        return findList;
    }

    public void printList() {
        if (findList.size() < 1) {
            System.out.println("Sorry, but your file was not found");
        } else {
            for (Path p : findList) {
                System.out.println(p.toString());
            }
        }
    }
}
