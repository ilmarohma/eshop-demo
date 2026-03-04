package Template;

class BadCoffee {
    void prepareRecipe() {
        boilWater();      
        brewCoffeeGrinds(); 
        pourInCup();      
        addSugarAndMilk();  
    }
    void boilWater() { System.out.println("Boiling water"); }
    void brewCoffeeGrinds() { System.out.println("Dripping Coffee through filter"); }
    void pourInCup() { System.out.println("Pouring into cup"); }
    void addSugarAndMilk() { System.out.println("Adding Sugar and Milk"); }
}

class BadTea {
    void prepareRecipe() {
        boilWater();       
        steepTeaBag();     
        pourInCup();       
        addLemon();       
    }
    void boilWater() { System.out.println("Boiling water"); }
    void steepTeaBag() { System.out.println("Steeping the tea"); }
    void pourInCup() { System.out.println("Pouring into cup"); }
    void addLemon() { System.out.println("Adding Lemon"); }
    }

public class MainBad {
    public static void main(String[] args) {
        

        System.out.println("--- Testing Bad Barista ---");

        System.out.println("--- Making Coffee ---");
        BadCoffee coffee = new BadCoffee();
        coffee.prepareRecipe();
        
        System.out.println("--- Making Tea ---");
        
        BadTea tea = new BadTea();
        tea.prepareRecipe();
    }
}