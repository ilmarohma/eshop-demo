package Decorator;

class BadBeverage {
    private String description;
    private boolean hasMilk;
    private boolean hasMocha;
    private boolean hasWhip;

    public BadBeverage(String description) {
        this.description = description;
    }

    // Setters for condiments
    public void setMilk(boolean hasMilk) { this.hasMilk = hasMilk; }
    public void setMocha(boolean hasMocha) { this.hasMocha = hasMocha; }
    public void setWhip(boolean hasWhip) { this.hasWhip = hasWhip; }

    public String getDescription() {
        return description 
            + (hasMilk ? ", Milk" : "") 
            + (hasMocha ? ", Mocha" : "") 
            + (hasWhip ? ", Whip" : "");
    }

    public double cost() {
        double totalCost = 0.0;
        if (description.equals("Espresso")) {
            totalCost += 1.99;
        } else if (description.equals("House Blend")) {
            totalCost += 0.89;
        }
        
        if (hasMilk) totalCost += 0.10;
        if (hasMocha) totalCost += 0.20;
        if (hasWhip) totalCost += 0.10;
        
        return totalCost;
    }
}

public class MainBad {
    public static void main(String[] args) {
        System.out.println("--- Testing Bad Coffee Design ---");
        BadBeverage myOrder = new BadBeverage("Espresso");
        myOrder.setMocha(true);
        myOrder.setWhip(true);
        
        System.out.println(myOrder.getDescription() + " $" + myOrder.cost());
    }
}