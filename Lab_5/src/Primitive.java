import java.io.Serializable;

public abstract class Primitive implements Serializable {
    protected String name;

    public Primitive(String name) {
        this.name = name;
        Logger.log("Primitive", "Created: " + name, "message");
    }

    public String getName() {
        return name;
    }

    public abstract void draw();
}
