package main;

import java.nio.file.Path;
import java.util.function.Predicate;

public class ConditionFactory {
    private Predicate<Path> predicate;

    public ConditionFactory(String findType, String fileName) {
        createPedicate(findType, fileName);
    }

    private void createPedicate(final String findType, final String fileName) {
        if (findType.equals("-f")) {
            predicate = s -> s.getFileName()
                    .toString()
                    .equals(fileName);
        }
        if (findType.equals("-m")) {
            predicate = s -> s.getFileName()
                    .toString()
                    .endsWith(fileName.split("\\.")[1]);
                }
        }

    public Predicate<Path> getPredicate() {
        if (predicate != null) {
            return predicate;
        } else  {
            throw new IllegalArgumentException("Predicate must not be zero");
        }
    }

}

