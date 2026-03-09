package Template;

abstract class CaffeineBeverage {
    
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();
    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}

class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}

public class MainRefactored {
    public static void main(String[] args) {


        System.out.println("--- Testing Refactored Barista ---");

        CaffeineBeverage coffee = new Coffee();

        System.out.println("Making Coffee...");
        coffee.prepareRecipe(); 

        System.out.println("\nMaking Tea...");

        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }
}