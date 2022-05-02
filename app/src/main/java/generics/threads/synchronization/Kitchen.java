package generics.threads.synchronization;

public class Kitchen {

    public static Object spoon = new Object();
    public static Object bowl = new Object();
    
    public static void main(String[] args) {
        
        Thread cook1 = new Thread(() -> {
            synchronized (spoon) {
                System.out.println("Cook1: Holding tbe spoon...");
                System.out.println("Cook1: Waiting for bowl...");

                synchronized (bowl) {
                    System.out.println("Cook1: Holding the spoon and the bowl.");
                }
            }
        });

        Thread cook2 = new Thread(() -> {
            synchronized (bowl) {
                System.out.println("Cook2: Holding tbe bowl...");
                System.out.println("Cook2: Waiting for spoon...");

                synchronized (spoon) {
                    System.out.println("Cook2: Holding the spoon and the bowl.");
                }
            }
        });

        cook1.start();
        cook2.start();
    }
}
