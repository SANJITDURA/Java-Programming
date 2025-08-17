abstract class Appliance {
    private boolean isOn;

    public Appliance() {
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() throws Exception {
        if (isOn) {
            throw new Exception("Appliance is already on.");
        }
        isOn = true;
        System.out.println(this.getClass().getSimpleName() + " is turned on.");
    }

    public void turnOff() throws Exception {
        if (!isOn) {
            throw new Exception("Appliance is already off.");
        }
        isOn = false;
        System.out.println(this.getClass().getSimpleName() + " is turned off.");
    }
}
class Fan extends Appliance {
    @Override
    public void turnOn() throws Exception {
        super.turnOn();
        System.out.println("Fan is now spinning.");
    }

    @Override
    public void turnOff() throws Exception {
        super.turnOff();
        System.out.println("Fan has stopped spinning.");
    }
}
class Light extends Appliance {
    @Override
    public void turnOn() throws Exception {
        super.turnOn();
        System.out.println("Light is now glowing.");
    }

    @Override
    public void turnOff() throws Exception {
        super.turnOff();
        System.out.println("Light has turned off.");
    }
}
class AC extends Appliance {
    @Override
    public void turnOn() throws Exception {
        super.turnOn();
        System.out.println("AC is now cooling.");
    }

    @Override
    public void turnOff() throws Exception {
        super.turnOff();
        System.out.println("AC has turned off.");
    }
}
public class ApplianceControlSystem {
    public static void main(String[] args) {
        Appliance[] appliances = { new Fan(), new Light(), new AC() };

        for (Appliance appliance : appliances) {
            try {
                appliance.turnOn();
                appliance.turnOff();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
