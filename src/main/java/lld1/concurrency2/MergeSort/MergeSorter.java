package lld1.concurrency2.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    private List<Integer> listToSort;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> list, ExecutorService executorService) {
        listToSort = list;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        int n = listToSort.size();

        if(n <= 1)
            return listToSort;

        int mid = n/2;

        List<Integer> leftArray = new ArrayList<>(listToSort.subList(0, mid));
        List<Integer> rightArray = new ArrayList<>(listToSort.subList(mid, n));

        // Create two Sorter tasks
        MergeSorter leftSorter = new MergeSorter(leftArray, executorService);
        MergeSorter rightSorter = new MergeSorter(rightArray, executorService);

        //Submit the task to the executor to run in PARALLEL
        Future<List<Integer>> leftFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightFuture = executorService.submit(rightSorter);

        //Wait for both the results
        List<Integer> sortedLeft = leftFuture.get();
        List<Integer> sortedRight = rightFuture.get();

        //merge the two sorted halves

        List<Integer> list = merge(sortedLeft, sortedRight);

        return list;
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while(i < left.size() && j < right.size()) {
            if(left.get(i) <= right.get(i)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Add the remaining elements
        while( i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while( j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
