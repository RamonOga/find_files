package main;

import java.nio.file.Path;

public class Validate {
    private Path directory;
    private String fileName;
    private String findType;
    private String logName;

    public Validate(String[] args) {
        args = splitArgs(args);
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

    private String[] splitArgs(String[] args) {
        StringBuffer buffer = new StringBuffer();
        for (String s : args) {
            buffer.append(s);
            buffer.append(" ");
        }
        return buffer.toString().split("-");
    }

    private void fillAllFields(String[] args) {
        if (args.length < 5) {
            exceptionThrow("Enter arguments. For example: java -jar \"find_files.java\""
                    + " -d \"your directory\" - n \"name file\" -m(search by mask) or -f(search ) -o \"name your log file\"");
        }

        if (args[1].charAt(0) == 'd') {
            directory = Path.of(args[1].split(" ")[1]);
        } else {
            exceptionThrow("First argument must be -d");
        }
        if (args[2].charAt(0) == 'n') {
            fileName = args[2].split(" ")[1];
        } else {
            exceptionThrow("Second argument must be -d");
        }
        if (args[3].equals("m ") || args[3].equals("f ") || args[3].equals("r ")) {
            findType = args[3];
        } else {
            exceptionThrow("Third argument must be -m or -f or -r");
        }
        if (args[4].charAt(0) == 'o') {
            logName = args[4].split(" ")[1];
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
