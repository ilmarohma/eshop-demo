package chainofresponsibility;

public class MoneyChanger {
    public static void main(String[] args){
        HundredHandler hundredHandler = new HundredHandler();
        FiftyHandler fiftyHandler = new FiftyHandler();
        TenHandler tenHandler = new TenHandler();
        FiveHandler fiveHandler = new FiveHandler();
        OneHandler oneHandler = new OneHandler();

        hundredHandler.setNextHandler(fiftyHandler);
        fiftyHandler.setNextHandler(tenHandler);
        tenHandler.setNextHandler(fiveHandler);
        fiveHandler.setNextHandler(oneHandler);

        System.out.println("You got:");
        hundredHandler.handle(126);

    }
}
