import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Logger {
    private static boolean loggingEnabled = true;

    static {
        try (InputStream input = new FileInputStream("lab4.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            loggingEnabled = "on".equalsIgnoreCase(prop.getProperty("logging", "on"));
        } catch (IOException e) {
            System.err.println("lab4.properties not found. Logging ON by default.");
        }
    }

    public static void log(String className, String message, String type) {
        if (!loggingEnabled) return;

        String user = System.getProperty("user.name");
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String line = String.format("%s %s %s %s%n", timestamp, user, message, type);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(className + ".log", true))) {
            bw.write(line);
        } catch (IOException e) {
            System.err.println("Error writing to log: " + e.getMessage());
        }
    }
}
