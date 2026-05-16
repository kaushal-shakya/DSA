package lld1.lambdas.functionalinterface;

import java.util.Comparator;

public class LambdaClient {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println("Hello world from lambda");
        };

        // () -> parameters of the method run()
        // -> it means lambda arrow, read as "goes to". i.e. parameter goes to
        // { body } -> the implementation

        Thread t = new Thread(task1);
        t.start();

        //1. No params
        Runnable r = () -> System.out.println("Hello");

        //2. Multi line body -> needs curly braces and return
        Comparator<Integer> comp = (a, b) -> {
            if(a > b) return 1;
            else if(a < b) return  -1;
            else return 0;
        };

        // single line without curly braces
        Comparator<Integer> com = (a,b) -> a-b;

        //Singe expression body
        Comparator<Integer> comp3 = Integer::compare;

    }
}
