package State;

class BadGumballMachine {
    final static int NO_QUARTER = 0;
    final static int HAS_QUARTER = 1;
    
    int currentState = NO_QUARTER;

    public void insertQuarter() {
        if (currentState == HAS_QUARTER) {
            System.out.println("You can't insert another quarter.");
        } else if (currentState == NO_QUARTER) {
            currentState = HAS_QUARTER;
            System.out.println("You inserted a quarter.");
        }
    }

    public void turnCrank() {
        if (currentState == HAS_QUARTER) {
            System.out.println("Crank turned! Dispensing gumball...");
            currentState = NO_QUARTER; 
        } else if (currentState == NO_QUARTER) {
            System.out.println("You turned the crank, but there's no quarter!");
        }
    }
}

public class MainBad {
    public static void main(String[] args) {
        BadGumballMachine machine = new BadGumballMachine();
        
        System.out.println("--- Testing Bad Gumball Machine ---");
        machine.turnCrank();      // Fails: no quarter
        machine.insertQuarter();  // Success: quarter inserted
        machine.insertQuarter();  // Fails: already has quarter
        machine.turnCrank();      // Success: dispenses and resets
    }
}