import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Editor implements Serializable {
    private List<Primitive> primitives = new ArrayList<>();

    public void add(Primitive p) {
        primitives.add(p);
        Logger.log("Editor", "Added primitive: " + p.getName(), "message");
    }

    public void renderAll() {
        for (Primitive p : primitives) {
            p.draw();
        }
    }

    public List<Primitive> getPrimitives() {
        return primitives;
    }
}
