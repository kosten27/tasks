package task3.models;

public class Triangle {
    private final String name;
    private final double side1;
    private final double side2;
    private final double side3;
    private final double area;

    public Triangle(String name, double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.name = name;
        this.area = calculateArea();
    }

    private double calculateArea() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public String getName() {
        return name;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("[%s]: %.2f cm", name, area);
    }
}
