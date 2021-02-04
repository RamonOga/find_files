package main;

import java.nio.file.Path;

public class Validate {
    private Path directory;
    private String fileName;
    private String findType;
    private String logName;

    public Validate(String[] args) {
        fillAllFields(args);
    }

    public Path getDirectory() {
        return directory;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFindType() {
        return findType;
    }

    public String getLogName() {
        return logName;
    }

    private void fillAllFields(String[] args) {
        if (args.length < 7) {
            exceptionThrow("Enter arguments. For example: java -jar \"find_files.java\""
                    + " -d \"your directory\" - n \"name file\" -m(search by mask) or -f(search ) -o \"name your log file\"");
        }

        if (args[0].equals("-d")) {
            directory = Path.of(args[1]);
        } else {
            exceptionThrow("First argument must be -d");
        }
        if (args[2].equals("-n")) {
            fileName = args[3];
        } else {
            exceptionThrow("Second argument must be -d");
        }
        if (args[4].equals("-m") || args[4].equals("-f") || args[4].equals("-r")) {
            findType = args[4];
        } else {
            exceptionThrow("Third argument must be -m or -f or -r");
        }
        if (args[5].equals("-o")) {
            logName = args[6];
        } else {
            exceptionThrow("Fourth argument must be -o");
        }
    }

    public void printFields() {
        System.out.println(directory);
        System.out.println(fileName);
        System.out.println(findType);
        System.out.println(logName);
    }

    private void exceptionThrow(String text) {
        throw new IllegalArgumentException(text);
    }
}
