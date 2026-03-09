package chainofresponsibility;

public class HundredHandler implements Handler {

    private Handler nextHandler;
    private int denomination = 100;

    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    @Override
    public void handle(int balance) {
        int amountOfBill = balance / denomination;
        int remainder = balance % denomination;

        if(remainder > 0){
            this.nextHandler.handle(remainder);
        }

        System.out.println(amountOfBill + " piece of $" + denomination);
    }
}
