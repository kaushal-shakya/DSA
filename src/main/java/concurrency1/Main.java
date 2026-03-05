package concurrency1;

public class Main {
    public static void main(String[] args) {
        //Java by default creates a main thread to run our application.
        System.out.println("Hello class,  this is printed by " + Thread.currentThread().getName()); //op: Hello class,  this is printed by main

        HelloWordPrinter helloWordPrinter = new HelloWordPrinter();
        Thread t1 = new Thread(helloWordPrinter);
        t1.start();
    }
}
