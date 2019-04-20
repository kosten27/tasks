package models;

public class Envelope {
    private final double height;
    private final double width;

    public Envelope(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
