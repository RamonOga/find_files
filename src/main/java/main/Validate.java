package main;

import java.nio.file.Path;

/*      -d c:/ -n *.txt -m -o
        -d - директория, в которой начинать поиск.
        -n - имя файла, маска, либо регулярное выражение.
        -m - искать по маске, либо -f - полное совпадение имени. -r регулярное выражение.
        -o - результат записать в файл.*/
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
        if (args[1].charAt(0) == 'd') {
            directory = Path.of(args[1].split(" ")[1]);
        } else {
            throw new IllegalArgumentException("First argument must be -d");
        }
        if (args[2].charAt(0) == 'n') {
            fileName = args[2].split(" ")[1];
        } else {
            throw new IllegalArgumentException("Second argument must be -d");
        }
        if (args[3].equals("m ") || args[3].equals("f ") || args[3].equals("r ")) {
            findType = args[3];
        } else {
            throw new IllegalArgumentException("Third argument must be -m or -f or -r");
        }
        if (args[4].charAt(0) == 'o') {
            logName = args[4].split(" ")[1];
        } else {
            throw new IllegalArgumentException("Fourth argument must be -o");
        }
    }


}
