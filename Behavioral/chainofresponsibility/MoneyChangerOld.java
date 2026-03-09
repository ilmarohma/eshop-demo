package chainofresponsibility;

public class MoneyChangerOld {
    public static void main(String[] args){
        denominateMoney(125);
    }

    public static void denominateMoney(int amount){

        int currentBillAmount = amount;

        int amountOfHundredBill = currentBillAmount / 100;
        currentBillAmount = currentBillAmount % 100;

        int amountOfFiftyBill = currentBillAmount / 50;
        currentBillAmount = currentBillAmount % 50;

        int amountOfTenBill = currentBillAmount / 10;
        currentBillAmount = currentBillAmount % 10;

        int amountOfFiveBill = currentBillAmount / 5;
        currentBillAmount = currentBillAmount % 5;

        int amountOfOneBill = currentBillAmount / 1;
        currentBillAmount = currentBillAmount % 1;

        if(currentBillAmount > 0){
            System.out.println("Failed to denominate. Remaining amount is "+Integer.toString(currentBillAmount));
        } else{
            System.out.println("You got:");
            System.out.println(amountOfHundredBill + " piece of $100");
            System.out.println(amountOfFiftyBill + " piece of $50");
            System.out.println(amountOfTenBill + " piece of $10");
            System.out.println(amountOfFiveBill + " piece of $5");
            System.out.println(amountOfOneBill + " piece of $1");
        }

    }

}
