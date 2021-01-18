package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Runner {
    public static void main(String[] args) throws IOException {
        Validate validate = new Validate(args);
        FindVisitor findVisitor = new FindVisitor(validate.getFindType(), validate.getFileName());
        Files.walkFileTree(validate.getDirectory(), findVisitor);

        for (Path p : findVisitor.getFindList()) {
            System.out.println(p.toString());
        }

    }
}
