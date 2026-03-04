class Light {
    public void turnOn() { System.out.println("Light is ON"); }
}

class GarageDoor {
    public void up() { System.out.println("Garage Door is UP"); }
}

class BadRemoteControl {
    private Object slot;
    private String deviceType;

    public void setSlot(Object device, String type) {
        this.slot = device;
        this.deviceType = type;
    }

    public void pressButton() {
        if (deviceType.equals("Light")) {
            ((Light) slot).turnOn();
        } else if (deviceType.equals("GarageDoor")) {
            ((GarageDoor) slot).up();
        } 
    }
}

public class MainCommandBad {
    public static void main(String[] args) {
        BadRemoteControl remote = new BadRemoteControl();
        
        Light livingRoomLight = new Light();
        GarageDoor garage = new GarageDoor();

        System.out.println("--- Testing Bad Remote ---");

        remote.setSlot(livingRoomLight, "Light");
        remote.pressButton();

        remote.setSlot(garage, "GarageDoor");
        remote.pressButton();
    }
}