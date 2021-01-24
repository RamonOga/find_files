package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LogWriter {
    private final String logFile;

    public  LogWriter(String logFile) {
        this.logFile = logFile;
    }

    public void writeLog(List<Path> pathList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile))) {
            for (Path path : pathList) {
                bw.write(path.toString());
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }
    }
}
