abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width cannot be negative.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class AbstractShapeClass{
    public static void main(String[] args) {
        try {
            Shape circle = new Circle(5);
            System.out.println("Area of Circle: " + circle.calculateArea());

            Shape rectangle = new Rectangle(4, 6);
            System.out.println("Area of Rectangle: " + rectangle.calculateArea());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
