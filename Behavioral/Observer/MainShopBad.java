// Concrete Client 1
class MobileAppClient {
    public void sendPushNotification(String productName) {
        System.out.println("Push Notification to App: New product available - " + productName);
    }
}

// Concrete Client 2
class EmailClient {
    public void sendEmail(String productName) {
        System.out.println("Email sent: Check out our new product - " + productName);
    }
}

class Shop {
    private MobileAppClient mobileClient;
    private EmailClient emailClient;

    public void setMobileClient(MobileAppClient mobileClient) {
        this.mobileClient = mobileClient;
    }

    public void setEmailClient(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void releaseNewProduct(String productName) {
        System.out.println("\n--- Shop: Releasing new product: " + productName + " ---");
        
        if (mobileClient != null) {
            mobileClient.sendPushNotification(productName);
        }
        if (emailClient != null) {
            emailClient.sendEmail(productName);
        }
    }
}

public class MainShopBad {
    public static void main(String[] args) {
        Shop myShop = new Shop();
        
        MobileAppClient user1 = new MobileAppClient();
        EmailClient user2 = new EmailClient();

        myShop.setMobileClient(user1);
        myShop.setEmailClient(user2);
        
        myShop.releaseNewProduct("Mechanical Keyboard");
        myShop.releaseNewProduct("Ergonomic Mouse");
    }
}