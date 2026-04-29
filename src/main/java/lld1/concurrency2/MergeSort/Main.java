package lld1.concurrency2.MergeSort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numList = Arrays.asList(4,6,2,1,78,43,23,67,9,12,-1);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<List<Integer>> listFuture = executorService.submit(new MergeSorter(numList, executorService));

        List<Integer> sortedList = listFuture.get();

        System.out.println(sortedList);
    }
}
