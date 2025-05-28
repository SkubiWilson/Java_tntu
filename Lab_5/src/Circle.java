public class Circle extends Primitive {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
        Logger.log("Circle", "Circle created with radius " + radius, "message");
    }

    @Override
    public void draw() {
        Logger.log("Circle", "Drawing circle: " + name, "message");
        System.out.println("Drawing circle: " + name);
    }
}
