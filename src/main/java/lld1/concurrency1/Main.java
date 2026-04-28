package lld1.concurrency1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Java by default creates a main thread to run our application.
        System.out.println("Hello class,  this is printed by " + Thread.currentThread().getName()); //op: Hello class,  this is printed by main

        //Using a separate class
        HelloWordPrinter helloWordPrinter = new HelloWordPrinter();

        System.out.println("----Calling run() directly : Direct run Method Invocation -----");
        helloWordPrinter.run();

        Thread t1 = new Thread(helloWordPrinter); // NEW Thread is a thread that’s been created
        System.out.println("-----Calling start()-------");
        t1.start(); // Calling start() method, it’s moved from NEW to RUNNABLE state.
        System.out.println(t1.getState()); // RUNNABLE

//        t1.start(); // This throws IllegalThreadStateException.
        //Anonymous class, no separate class
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World, Thread name " + Thread.currentThread().getName());
            }
        });
        t2.start();

        //Lambda -> Works with Functional Interfaces.
        //() -> {}
        Thread t3 = new Thread(() -> {
            System.out.println("Hello World, Thread name " + Thread.currentThread().getName());
        });
//        t3.start();
    }
}
