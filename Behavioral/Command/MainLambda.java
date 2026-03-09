class Light {
    public void turnOn() { System.out.println("Light is ON"); }
}

class GarageDoor {
    public void up() { System.out.println("Garage Door is UP"); }
}

interface Command {
    void execute();
}

class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        slot.execute();
    }
}

public class MainLambda {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        
        Light livingRoomLight = new Light();
        GarageDoor garage = new GarageDoor();

        Command lightOn = () -> {
            livingRoomLight.turnOn();
        };

        Command garageOpen = () -> {
            garage.up();
        };

        System.out.println("--- Testing Refactored Remote ---");
        
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is ON

        remote.setCommand(garageOpen);
        remote.pressButton(); // Output: Garage Door is UP
    }
}