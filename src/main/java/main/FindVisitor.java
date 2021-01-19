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
    ConditionFactory conFac = new ConditionFactory();
    private List<Path> findList = new ArrayList<>();
    Predicate<Path> predicate;

    public FindVisitor(final String findType,final String fileName) {
        this.predicate = conFac.createPedicate(findType, fileName);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
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

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            findList.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getFindList() {
        return findList;
    }


}
