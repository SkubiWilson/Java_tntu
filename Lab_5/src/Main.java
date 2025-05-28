public class Main {
    public static void main(String[] args) {
        SystemInfoLogger.logSystemInfo();
        Editor editor = new Editor();

        editor.add(new Circle("Circle1", 5.0));
        editor.add(new Line("Line1", 10.0));
        editor.add(new Square("Square1", 3.0));

        editor.renderAll();

        // Серіалізація
        Serializer.save(editor, "editor.ser");

        // Десеріалізація
        Editor loaded = (Editor) Deserializer.load("editor.ser");

        if (loaded != null) {
            System.out.println("\nLoaded primitives:");
            for (Primitive p : loaded.getPrimitives()) {
                System.out.println("- " + p.getClass().getName() + ": " + p.getName());
            }
        }
    }
}
