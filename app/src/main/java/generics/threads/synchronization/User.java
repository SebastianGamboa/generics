package generics.threads.synchronization;

public class User {
    
    public static final BankAccount ACCOUNT = new BankAccount(50);

    public static void main(String[] args) {
        
        ACCOUNT.topUp(100);

        Thread t1 = new Thread(() -> ATM.withdraw(ACCOUNT, 100));
        Thread t2 = new Thread(() -> ATM.withdraw(ACCOUNT, 100));
        t1.start();
        t2.start();
    }
}
