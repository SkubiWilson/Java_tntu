import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class LabWork4 {

    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp();
            return;
        }

        switch (args[0]) {
            case "systems_info":
                printSystemInfo();
                break;
            case "list":
                listLogFiles();
                break;
            case "printlog":
                if (args.length < 3) {
                    System.out.println("Usage: java LabWork4 printlog ClassName 0|1");
                } else {
                    printLog(args[1], args[2]);
                }
                break;
            case "help":
            default:
                printHelp();
                break;
        }
    }

    private static void printSystemInfo() {
        Path path = Paths.get("system_info.txt");
        if (!Files.exists(path)) {
            System.out.println("system_info.txt not found.");
            return;
        }

        try {
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            Logger.log("LabWork4", "Error reading system_info.txt: " + e.getMessage(), "exception");
        }
    }

    private static void listLogFiles() {
        try {
            Files.list(Paths.get("."))
                    .filter(p -> p.toString().endsWith(".log"))
                    .forEach(p -> System.out.println(p.getFileName()));
        } catch (IOException e) {
            Logger.log("LabWork4", "Error listing log files: " + e.getMessage(), "exception");
        }
    }

    private static void printLog(String className, String orderFlag) {
        Path path = Paths.get(className + ".log");
        if (!Files.exists(path)) {
            System.out.println("Log file for class " + className + " not found.");
            return;
        }

        try {
            List<String> lines = Files.readAllLines(path);
            Comparator<String> comparator = Comparator.comparing(line -> {
                try {
                    return line.substring(0, 19); // date + time
                } catch (Exception e) {
                    return "";
                }
            });

            if ("1".equals(orderFlag)) {
                lines.sort(comparator.reversed());
            } else {
                lines.sort(comparator);
            }

            lines.forEach(System.out::println);
        } catch (IOException e) {
            Logger.log("LabWork4", "Error reading log: " + e.getMessage(), "exception");
        }
    }

    private static void printHelp() {
        System.out.println("Usage:");
        System.out.println("java LabWork4 systems_info       - Show previous program launches");
        System.out.println("java LabWork4 list               - Show available class log files");
        System.out.println("java LabWork4 printlog Class 0|1 - Show log (0 - asc, 1 - desc)");
        System.out.println("java LabWork4 help               - Show this help message");
    }
}
