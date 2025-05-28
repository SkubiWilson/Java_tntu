public class Square extends Primitive {
    private double side;

    public Square(String name, double side) {
        super(name);
        this.side = side;
        Logger.log("Square", "Square created with side " + side, "message");
    }

    @Override
    public void draw() {
        Logger.log("Square", "Drawing square: " + name, "message");
        System.out.println("Drawing square: " + name);
    }
}
