package generics.threads.synchronization;

public class ATM {
    
    public static synchronized void withdraw(BankAccount account, int amount) {
        int balance = account.getBalance();
        if ((balance - amount) < - account.getOverdraft()) {
            System.err.println("Transaction denied");
        } else {
            account.debit(amount);
            System.out.println("$" + amount + " successfully withdraw");
        }
        System.out.println("Current balance: " + account.getBalance());
    }
}
