package concurrency2.MergeSort;

import java.util.List;
import java.util.concurrent.Callable;

public class MergeSorter implements Callable<List<Integer>> {

    private List<Integer> listToSort;

    public MergeSorter(List<Integer> list) {
        listToSort = list;
    }

    @Override
    public List<Integer> call() throws Exception {
        int n = listToSort.size();

        if(n <= 1)
            return listToSort;

        return List.of();
    }
}
