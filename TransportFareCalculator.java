abstract class Transport {
    private double distance;

    public Transport(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative.");
        }
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public abstract double calculateFare();
}

class Bus extends Transport {
    private static final double FARE_PER_KM = 1.5;
    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * FARE_PER_KM;
    }
}

class Train extends Transport {
    private static final double FARE_PER_KM = 2.0;

    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * FARE_PER_KM;
    }
}

class Taxi extends Transport {
    private static final double FARE_PER_KM = 3.0; 

    public Taxi(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * FARE_PER_KM;
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Transport[] transports = {
            new Bus(10),   // 10 km
            new Train(15), // 15 km
            new Taxi(5)    // 5 km
        };

        System.out.println("Calculating fares for different transport modes...\n");

        for (Transport transport : transports) {
            try {
                double fare = transport.calculateFare();
                System.out.printf("Transport Type: %s, Distance: %.2f km, Fare: $%.2f%n",
                        transport.getClass().getSimpleName(), transport.getDistance(), fare);
            } catch (Exception e) {
                System.out.println("Error calculating fare: " + e.getMessage());
            }
        }

        System.out.println("\nTesting error case...");
        try {
            Transport invalidTransport = new Bus(-5);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
