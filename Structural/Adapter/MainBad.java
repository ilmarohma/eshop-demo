class LegacyBankAPIBad {
    public void processOldPayment(String account, double amount) {
        System.out.println("Processing legacy bank transfer for " + account + " : Rp" + amount);
    }
}

class ModernEWalletAPIBad {
    public void chargeWallet(String phoneNumber, double amount) {
        System.out.println("Charging E-Wallet for " + phoneNumber + " : Rp" + amount);
    }
}

class CheckoutProcessorBad {
    public void checkoutWithBank(LegacyBankAPI bank, String account, double amount) {
        bank.processOldPayment(account, amount);
    }

    public void checkoutWithEWallet(ModernEWalletAPIBad eWallet, String phone, double amount) {
        eWallet.chargeWallet(phone, amount);
    }
}

public class MainBad {
    public static void main(String[] args) {
        CheckoutProcessorBad processor = new CheckoutProcessorBad();
        LegacyBankAPI oldBank = new LegacyBankAPI();
        ModernEWalletAPIBad newWallet = new ModernEWalletAPIBad();

        System.out.println("--- Bad Checkout System ---");
        processor.checkoutWithBank(oldBank, "NPM-123456", 500000.0);
        processor.checkoutWithEWallet(newWallet, "08123456789", 150000.0);
    }
}