abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius: " + radius);
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side length must be greater than zero.");
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square with side: " + side);
    }
}

class Triangle extends Shape {
    private double base;
    private double height; 

    public Triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be greater than zero.");
        }
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle with base: " + base + " and height: " + height);
    }
}

public class ShapeDrawer {
    public static void main(String[] args) {
        try {
            Shape[] shapes = {
                new Circle(5),
                new Square(4),
                new Triangle(6, 3)
            };

            for (Shape shape : shapes) {
                shape.draw();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}