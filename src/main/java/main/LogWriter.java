package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LogWriter {
    private final String logFile;
    private final String folderPath = ".\\src\\main\\java\\data\\";

    public  LogWriter(String logFile) {
        this.logFile = logFile;
    }

    public void writeLog(List<Path> pathList) {
        createFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(folderPath + logFile))) {
            for (Path path : pathList) {
                bw.write(path.toString());
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }
    }

    private void createFile() {
        try {
            if(!Files.exists(Path.of(folderPath))) {
                Files.createDirectories(Path.of(folderPath));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }
        try {
            if(!Files.exists(Path.of(folderPath + logFile))) {

                Files.createFile(Path.of(folderPath + logFile));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }
    }
}
