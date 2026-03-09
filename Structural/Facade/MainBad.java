package Facade;

class Amplifier { void turnOn() { System.out.println("Amp on"); } }
class Projector { void turnOn() { System.out.println("Projector on"); } }
class Lights { void dim() { System.out.println("Lights dimmed"); } }


public class MainBad {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Projector projector = new Projector();
        Lights lights = new Lights();

        System.out.println("--- Get ready to watch a movie ---");
        lights.dim();
        amp.turnOn();
        projector.turnOn();
    }
}
