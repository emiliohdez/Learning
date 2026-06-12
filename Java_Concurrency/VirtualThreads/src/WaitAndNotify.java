public class WaitAndNotify {

    private static final Object monitor = new Object();
    private static String message = null;

    public static void main(String[] args) {

        Thread consumer = new Thread(() -> {
            synchronized (monitor) {

                while (message == null) {
                    try {
                        System.out.println("Consumer: waiting for message...");
                        monitor.wait();  // releases monitor and waits
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                System.out.println("Consumer received: " + message);
            }
        });

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(2000); // simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            synchronized (monitor) {
                message = "Hello from producer!";
                System.out.println("Producer: message ready");

                monitor.notify(); // wake one waiting thread
            }
        });

        consumer.start();
        producer.start();
    }
}