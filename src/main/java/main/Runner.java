package main;

import java.io.IOException;
import java.nio.file.Files;

public class Runner {
    public static void main(String[] args) throws IOException {
        printArgs(args);
        Validate validate = new Validate(args);
        ConditionFactory conFac = new ConditionFactory(validate.getFindType(), validate.getFileName());
        validate.printFields();
        FindVisitor findVisitor = new FindVisitor(conFac.getPredicate());
        Files.walkFileTree(validate.getDirectory(), findVisitor);
        LogWriter logWriter = new LogWriter(validate.getLogName());
        logWriter.writeLog(findVisitor.getFindList());
        findVisitor.printList();
    }

    public static void printArgs(String[] args) {
        int count = 0;
        System.out.println(" size = " + args.length);
        for (String a : args) {
            System.out.println(a + " : " + count);
            count++;
        }
    }
}
