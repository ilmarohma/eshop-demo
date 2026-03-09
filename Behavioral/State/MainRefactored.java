package State;

// 1. The State Interface (Abstracts the behavior for all states)
interface State {
    void insertQuarter();
    void turnCrank();
}

class NoQuarterState implements State{

    private GumballMachine machine;

    public NoQuarterState(GumballMachine machine){
        this.machine = machine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter. Changing state...");
        machine.setState(machine.getHasQuarterState()); 
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned the crank, but there's no quarter!");
    }
}

class HasQuarterState implements State{

    private GumballMachine machine;

    public HasQuarterState(GumballMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned! Dispensing gumball...");
        machine.setState(machine.getNoQuarterState()); // Transition back to NoQuarter
    }
}

class GumballMachine {
    private State hasQuarterState;
    private State noQuarterState;

    State currentState;

    public GumballMachine(){
        hasQuarterState = new HasQuarterState(this);
        noQuarterState = new NoQuarterState(this);

        currentState = noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    void setState(State state) {
        this.currentState = state;
    }

    void insertQuarter() {
        currentState.insertQuarter();
    }

    void turnCrank() {
        currentState.turnCrank();
    }
}

public class MainRefactored {
    public static void main(String[] args) {

        GumballMachine machine = new GumballMachine();

        System.out.println("--- Testing Refactored Gumball Machine ---");
        machine.turnCrank();      
        machine.insertQuarter();  
        machine.insertQuarter();  
        machine.turnCrank();     
    }
}
