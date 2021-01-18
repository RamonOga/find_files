package main;

import java.io.File;
import java.nio.file.FileVisitor;

public class Runner {
    public static void main(String[] args) {
        Validate validate = new Validate(args);
        System.out.println(validate.getDirectory());
        System.out.println(validate.getFileName());
        System.out.println(validate.getFindType());
        System.out.println(validate.getLogName());

    }
}
