package lld1.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsLevel1 {
    public static void main(String[] args) {

        List<Integer> list = List.of(1,2,3,4,5,6,7);

        /**
         * BinaryOperator is a functional interface which takes two arguments of same type and returns a result of same type
         * BinaryOperator is a input of reduce method
         */
        BinaryOperator<Integer> add = (number1, number2) -> number1 + number2;
        ///  reduce method take identity value and binary operator as arguments
        int ans = list.stream().reduce(-2, add);
        System.out.println("\nReduce takes an identity value and a binary operator as arguments --> " + ans);

        /**
         * In Function<T, R>, the first type parameter (T) is the input type, and the second type parameter (R) is the output (return) type.
         */
        Function<Integer, Long> function1 = (x) -> Long.valueOf((long) x * x);
        List<Long> mapList = list.stream().map(function1).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("\nMap takes function as an argument and return result after applying function to each stream of element --> " + mapList);

        /**
         * Consumer takes one input and returns no result.
         * void accept(T t); --> Perform this operation on given argument.
         */
        Consumer<Integer> consumer1 = (x) -> System.out.println(x + "*2=" + x*2);
        System.out.println("\nForeach performs an action for each element of this stream.");
        list.stream().forEach(consumer1);

        /**
         * A mutable reduction operation that accumulates input elements into a mutable result container,
         * optionally transforming the accumulated result into a final representation after all input elements have been processed.
         * Collectors.toList()
         * supplier()    -> () -> new ArrayList<>()
         * accumulator() -> (list, e) -> list.add(e)
         * combiner()    -> (l1, l2) -> { l1.addAll(l2); return l1; }
         * finisher()    -> identity (returns the list as-is)
         * <T> – the type of input elements to the reduction operation
         * <A> – the mutable accumulation type of the reduction operation (often hidden as an implementation detail)
         * <R> – the result type of the reduction operation
         */
        Collector<Integer, ?, ArrayList<Integer>> collector1 = Collectors.toCollection(ArrayList::new);
        List<Integer> collectorString = list.stream().collect(collector1);
        System.out.println("\nCollector " + collectorString);

        /***
         * Predicate is a functional interface
         */
        Predicate<Integer> predicate = (x) -> x % 2 != 0;
        List<Integer> listAfterPredicateFiltering = list.stream().filter(predicate).collect(Collectors.toList());
        System.out.println("\nFiltering after applying predicate : " + listAfterPredicateFiltering);

        boolean a = list.stream().allMatch(x -> x % 2 == 0);
        System.out.println("\nAllMatch, this check all the integers are divisible by 2 "+ a);

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println("\nAnyMatch, this check any integer is divisible by 2 "+ b);

        List<Integer> distinctListInput = List.of(1,2,3,4,5,5,6,7);
        List<Integer> disElements = distinctListInput.stream().distinct().collect(Collectors.toList());
        System.out.println("\nOriginal List : " + distinctListInput
            + "\nAfter applying distinct : " + disElements);

        /**
         * In Java, any local variable used inside a lambda expression (like sum inside the forEach) must be final or effectively final.
            int sum = 0;
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            numbers.forEach(n -> sum += n);
            System.out.println(sum);
        */


    }


}
