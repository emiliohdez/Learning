public class VirtualThreads {
    public static void main(String[] args) throws Exception {

        // Platform threads are heavy-weight threads that are managed by the operating system.
        // They are suitable for tasks that require a lot of CPU time or that need to perform
        // blocking operations, such as I/O.
        Thread platformThread = new Thread(() -> {
            System.out.println("This is a platform thread.");
        });
        platformThread.start();
        

        // Virtual threads are lightweight threads that are managed by the Java runtime. They are suitable for tasks that are short-lived or that need to perform non-blocking operations, such as asynchronous programming.
        Thread.startVirtualThread(() -> {
            System.out.println("This is a virtual thread.");
        });

        Thread.ofVirtual().unstarted(() -> {
            System.out.println("This is another virtual thread.");
        });
    }
}
