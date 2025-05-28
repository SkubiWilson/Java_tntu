import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemInfoLogger {
    public static void logSystemInfo() {
        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");
        String userName = System.getProperty("user.name");
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String info = String.format("Time: %s\nUser: %s\nOS: %s %s (%s)\nJava: %s (%s)\n\n",
                timestamp, userName, osName, osVersion, osArch, javaVersion, javaVendor);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("system_info.txt", true))) {
            writer.write(info);
            Logger.log("SystemInfoLogger", "System info written", "message");
        } catch (IOException e) {
            Logger.log("SystemInfoLogger", "Failed to write system info: " + e.getMessage(), "exception");
        }
    }
}
