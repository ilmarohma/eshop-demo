class Light {
    public void turnOn() { System.out.println("Light is ON"); }
}

class GarageDoor {
    public void up() { System.out.println("Garage Door is UP"); }
}

interface Command {
    void execute();
}

class SwitchLightCommand implements Command{
    private Light light;

    public SwitchLightCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

}

class SwitchGarageCommand implements Command{
    private GarageDoor garage;

    public SwitchGarageCommand(GarageDoor garage){
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.up();
    }

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


public class MainCommandRefactored {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        
        Light livingRoomLight = new Light();
        GarageDoor garage = new GarageDoor();

        Command lightOn = new SwitchLightCommand(livingRoomLight);

        Command garageOpen = new SwitchGarageCommand(garage);

        System.out.println("--- Testing Refactored Remote ---");
        
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is ON

        remote.setCommand(garageOpen);
        remote.pressButton(); // Output: Garage Door is UP
    }
}