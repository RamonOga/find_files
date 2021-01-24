package main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class RunnerTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void findTest() throws IOException {

        String[] args = {"-d", "C:\\Users\\User\\AppData\\Local\\Temp", "-n", "*.ghl", "-m", "-o", "log.txt"};
        folder.newFile("file1.ghl");
        folder.newFile("file2.ghl");
        Validate validate = new Validate(args);
        ConditionFactory conFac = new ConditionFactory(validate.getFindType(), validate.getFileName());
        FindVisitor findVisitor = new FindVisitor(conFac.getPredicate());
        Files.walkFileTree(validate.getDirectory(), findVisitor);
        LogWriter logWriter = new LogWriter(validate.getLogName());
        logWriter.writeLog(findVisitor.getFindList());
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\projects\\find_files\\src\\main\\java\\data\\log.txt"))) {
            assertEquals("ghl", br.readLine().split("\\.")[1]);
            assertEquals("ghl", br.readLine().split("\\.")[1]);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}







