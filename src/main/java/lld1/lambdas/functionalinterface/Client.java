package lld1.lambdas.functionalinterface;

public class Client {
    public static void main(String[] args) {
        Runnable task = new MyTask();
        //task - is the variable receiving the interface
        //new -> create a new instance of MyTask

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World..");
            }
        };

        // task 1 - is the variable receiving the interface
        // new - creating an instance of the anonymous class
        // Runnable() - interface which is being implemented by the anonymous class
        // opening braces -> class body start here
    }
}
