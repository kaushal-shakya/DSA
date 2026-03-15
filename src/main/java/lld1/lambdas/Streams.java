package lld1.lambdas;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list  = List.of(3,5,1,4,8,7,9,10);

        Stream<Integer> s1 = list.stream();
//        List<Integer> output = s1.filter((x) -> { return x%2 == 0; }).collect(Collectors.toList());
//        List<Integer> output = s1.filter(x ->  x%2 == 0 ).collect(Collectors.toList()); // similar to line 12
//        System.out.println(output);

        List<Integer> output1 = s1.filter(x ->  x%2 == 0 ).map(x -> x*x).collect(Collectors.toList());
        System.out.println(output1);

        List<String> words = List.of("java", "scaler", "lambda", "stream", "streams", "dsa");
        System.out.println(words.stream().filter(x -> x.length() > 3).count());
    }
}
