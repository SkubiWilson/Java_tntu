import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializer {
    public static Object load(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            Logger.log("Deserializer", "Loaded from file: " + filename, "message");
            return obj;
        } catch (Exception e) {
            Logger.log("Deserializer", "Load failed: " + e.getMessage(), "exception");
            return null;
        }
    }
}
