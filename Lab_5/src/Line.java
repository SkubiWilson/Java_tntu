public class Line extends Primitive {
    private double length;

    public Line(String name, double length) {
        super(name);
        this.length = length;
        Logger.log("Line", "Line created with length " + length, "message");
    }

    @Override
    public void draw() {
        Logger.log("Line", "Drawing line: " + name, "message");
        System.out.println("Drawing line: " + name);
    }
}
