
public class LockAndMonitor {

    public static void main(String[] args) {

        Object monitor = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println("T1 entering");
            synchronized (monitor) {
                System.out.println("T1 entered");
                try {
                    System.out.println("T1 is sleeping");
                    Thread.sleep(5000);
                    System.out.println("T1 sleep finished");
                } catch (InterruptedException e) {
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2 entering");
            synchronized (monitor) {
                System.out.println("T2 entered");
            }
        });

        t1.start();
        t2.start();
    }

}
