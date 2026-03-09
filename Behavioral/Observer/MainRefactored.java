import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String productName);
}

class MobileAppSubscriber implements Subscriber{
    public void sendPushNotification(String productName) {
        System.out.println("Push Notification to App: New product available - " + productName);
    }

    @Override
    public void update(String productName) {
       sendPushNotification(productName);;
    }
}

class EmailSubscriber implements Subscriber{
    public void sendEmail(String productName) {
        System.out.println("Email sent: Check out our new product - " + productName);
    }

    @Override
    public void update(String productName) {
        sendEmail(productName);
    }
    
}


class ShopPublisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void releaseNewProduct(String productName) {
        System.out.println("\n--- Shop: Releasing new product: " + productName + " ---");
        notifySubscribers(productName);
    }

    private void notifySubscribers(String productName) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(productName);
        }
    }
}

public class MainRefactored {
    public static void main(String[] args) {
        ShopPublisher myShop = new ShopPublisher();

        Subscriber mobileClient = new MobileAppSubscriber();
        Subscriber emailClient = new EmailSubscriber();

        myShop.subscribe(mobileClient);
        myShop.subscribe(emailClient);

        myShop.releaseNewProduct("Mechanical Keyboard");
        
        myShop.unsubscribe(emailClient);
        
        myShop.releaseNewProduct("Ergonomic Mouse");
    }
}