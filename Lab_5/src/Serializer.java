import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    public static void save(Object obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            Logger.log("Serializer", "Saved to file: " + filename, "message");
        } catch (Exception e) {
            Logger.log("Serializer", "Save failed: " + e.getMessage(), "exception");
        }
    }
}
