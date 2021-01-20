package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Runner {
    public static void main(String[] args) throws IOException {
        Validate validate = new Validate(args);
        validate.printFields();
        FindVisitor findVisitor = new FindVisitor(validate.getFindType(), validate.getFileName());
        Files.walkFileTree(validate.getDirectory(), findVisitor);
        LogWriter logWriter = new LogWriter(validate.getLogName());
        logWriter.writeLog(findVisitor.getFindList());
        findVisitor.printList();
    }
}
