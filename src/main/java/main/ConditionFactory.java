package main;

import java.nio.file.Path;
import java.util.function.Predicate;

public class ConditionFactory {
    public Predicate<Path> createPedicate(final String findType,final String fileName) {
        Predicate<Path> predicate = null;
        if (findType.equals("f ")) {
            predicate = s -> s.getFileName()
                    .toString()
                    .equals(fileName);
        }
        if (findType.equals("m ")) {
            predicate = s -> s.getFileName()
                    .toString()
                    .endsWith(fileName.split("\\.")[1]);
                }
        return predicate;
        }

    }
